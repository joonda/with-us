package org.joonda.withus.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventDto {
    private Long eventId;
    private String title;
    private String description;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private String organizer;
    private LocalDateTime createdAt;
}