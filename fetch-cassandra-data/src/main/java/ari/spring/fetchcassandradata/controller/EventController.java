package ari.spring.fetchcassandradata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ari.spring.fetchcassandradata.event.Event;
import ari.spring.fetchcassandradata.repository.EventRepository;

@RestController
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        try {
            List<Event> _events = eventRepository.findAll();
            if (_events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(_events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/events/station_id={station_id}")
    public ResponseEntity<List<Event>> getEventByStationId(
        @PathVariable("station_id") Long station_id
    ) {
        try {
            List<Event> _events = eventRepository.findByStationId(station_id);
            if (_events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(_events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/events/parameter={parameter}")
    public ResponseEntity<List<Event>> getEventByParameter(
        @PathVariable("parameter") String parameter
    ) {
        try {
            List<Event> _events = eventRepository.findByParameter(parameter);
            if (_events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(_events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/events/connection_id={connection_id}")
    public ResponseEntity<List<Event>> getEventByConnectionId(
        @PathVariable("connection_id") Long connection_id
    ) {
        try {
            List<Event> _events = eventRepository.findByConnectionId(connection_id);
            if (_events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(_events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // We don't want to affect our database, so these won't be implemented

    // @PostMapping("/models")
    // public void createModel(
    //     @RequestBody Event model
    // ) {

    // }

    // @PutMapping(value="/models/{id}")
    // public void update(@PathVariable UUID id, @RequestBody Event model) {
    //     //TODO: process PUT request
    // }

    // @DeleteMapping("/models/{id}")
    // public ResponseEntity<HttpStatus> deleteModel(
    //     @PathVariable String id
    // ) {
    //     return null;
    // }

    // Other queries can be implemented below here!
}
