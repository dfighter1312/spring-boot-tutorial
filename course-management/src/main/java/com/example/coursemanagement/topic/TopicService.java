package com.example.coursemanagement.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        // return topics;
        return topicRepository.findAll();
    }

    public Topic getTopic(String id) {
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).orElseThrow(() -> new IllegalStateException("No ID found"));
    }

    public void addTopic(Topic topic) {
        // topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        // for (int i = 0; i < topics.size(); i++) {
        //     Topic t = topics.get(i);
        //     if (t.getId().equals(id)) {
        //         topics.set(i, topic);
        //         return;
        //     }
        // }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        // topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
