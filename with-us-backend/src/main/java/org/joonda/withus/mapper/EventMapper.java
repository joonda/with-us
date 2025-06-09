package org.joonda.withus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.joonda.withus.dto.EventDto;

import java.util.List;

@Mapper
public interface EventMapper {
    List<EventDto> findAllEvents();

    EventDto findEventById(Long id);
}
