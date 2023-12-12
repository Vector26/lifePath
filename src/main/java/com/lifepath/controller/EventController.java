package com.lifepath.controller;
import com.lifepath.models.EventModel;
import com.lifepath.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventModel> createEvent(@RequestBody EventModel event) {
        EventModel newEvent = eventService.createEvent(event);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventModel> getEventById(@PathVariable Long id) {
        EventModel event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<List<EventModel>> getAllEvents() {
        List<EventModel> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventModel> updateEvent(@PathVariable Long id, @RequestBody EventModel updatedEvent) {
        EventModel event = eventService.updateEvent(id, updatedEvent);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (eventService.deleteEvent(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
