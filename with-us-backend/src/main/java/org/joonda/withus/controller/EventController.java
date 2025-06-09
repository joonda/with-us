package org.joonda.withus.controller;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.EventDto;
import org.joonda.withus.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public List<EventDto> findAllEvents() {
        return eventService.findAllEvents();
    }

    @GetMapping("/{eventId}")
    public EventDto findEventById(@PathVariable Long eventId) {
        return eventService.findEventById(eventId);
    }
}
