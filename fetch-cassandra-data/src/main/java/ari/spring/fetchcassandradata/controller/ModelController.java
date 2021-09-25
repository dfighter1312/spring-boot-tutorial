package ari.spring.fetchcassandradata.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ari.spring.fetchcassandradata.model.Model;
import ari.spring.fetchcassandradata.repository.ModelRepository;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ModelController {
    
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getAllModels(
        @RequestParam(required=false) String title
    ) {
        return null;
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<Model> getTutorialById(
        @PathVariable String id
    ) {
        return null;
    }

    @PostMapping("/models")
    public void createModel(
        @RequestBody Model model
    ) {

    }

    @PutMapping(value="/models/{id}")
    public void update(@PathVariable UUID id, @RequestBody Model model) {
        //TODO: process PUT request
    }

    @DeleteMapping("/models/{id}")
    public ResponseEntity<HttpStatus> deleteModel(
        @PathVariable String id
    ) {
        return null;
    }

    // Other queries can be implemented below here!
}
