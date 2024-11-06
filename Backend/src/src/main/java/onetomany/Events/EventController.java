package onetomany.Events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    private String success = "{\"message\":\"Success\"}";
    private String failure = "{\"message\":\"Failure\"}";

    @GetMapping(path = "/events")
    List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping(path = "/events/{id}")
    Event getEventById(@PathVariable int id) {
        return eventRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/events")
    String createEvent(@RequestBody Event event) {
        if (event == null) return failure;
        eventRepository.save(event);
        return success;
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(@PathVariable int id, @RequestBody Event request) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        if (existingEvent == null) {
            return null;
        }
        System.out.println();
        if (request.getEventName() != null) {
            existingEvent.setEventName(request.getEventName());
        }
        if (request.getDescription() != null) {
            existingEvent.setDescription(request.getDescription());
        }
        if (request.getEventLocation() != null) {
            existingEvent.setEventLocation(request.getEventLocation());
        }
        if (request.getDate() != null) {
            existingEvent.setDate(request.getDate());
        }

        eventRepository.save(existingEvent);
        return existingEvent;
    }

    @DeleteMapping(path = "/events/{id}")
    String deleteEvent(@PathVariable int id) {
        eventRepository.deleteById(id);
        return success;
    }
}