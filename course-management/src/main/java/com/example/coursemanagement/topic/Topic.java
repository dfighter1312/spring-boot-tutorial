package com.example.coursemanagement.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
    
    @Id     // To note that id is the primary key
    private String id;
    private String name;
    private String description;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Topic() {

    }
}
