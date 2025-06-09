package org.joonda.withus.service;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.EventDto;
import org.joonda.withus.mapper.EventMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventMapper eventMapper;

    public List<EventDto> findAllEvents() {
        return eventMapper.findAllEvents();
    }

    public EventDto findEventById(Long id) {
        EventDto event = eventMapper.findEventById(id);
        if (event == null) {
            throw new RuntimeException("이벤트를 찾을 수 없습니다.");
        }
        return event;
    }
}
