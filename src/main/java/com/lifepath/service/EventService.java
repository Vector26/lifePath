package com.lifepath.service;

import com.lifepath.models.EventModel;
import com.lifepath.models.UserModel;
import com.lifepath.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public EventModel createEvent(EventModel event) {
        return eventRepository.save(event);
    }

    public EventModel getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<EventModel> getAllEventsByUser(UserModel userModel) {
        return eventRepository.findByUserModelId(userModel.getId());
    }

    public EventModel updateEvent(Long id, EventModel updatedEvent) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setTitle(updatedEvent.getTitle());
                    event.setDescription(updatedEvent.getDescription());
                    event.setEventDate(updatedEvent.getEventDate());
                    // Set other fields as necessary
                    return eventRepository.save(event);
                }).orElse(null);
    }

    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
