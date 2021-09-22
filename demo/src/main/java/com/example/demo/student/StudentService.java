package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


    public List<Student> getStudents() {
		return studentRepository.findAll();
	}


    public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository
			.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email was taken");
		}
		studentRepository.save(student);
    }

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException(
				"student with id " + studentId + " does not exists"
			);
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email){
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new IllegalStateException(
				"student with id " + studentId + " does not exists"
			);
		}

		Student student_o = student.orElse(null);

		// Or we can use
		// Student student = studentRepository.findById(studentId)
		// 			.orElseThrow(() -> new IllegalStateException(""))

		if (name != null && name.length() > 0 && !Objects.equals(student_o.getName(), name)) {
			student_o.setName(name);	
		}
		if (email != null && email.length() > 0 && !Objects.equals(student_o.getEmail(), email)) {
			// Check if the email has already existed
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			student_o.setEmail(email);
		}
	}
}
