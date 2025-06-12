/*
 * 동행 모집 관련 DTO
 * Last Update: 25.06.12
 * */

package org.joonda.withus.dto;

import lombok.Data;
import org.joonda.withus.enums.GroupRecruitStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class GroupRecruitDto {
    private Long authorId;
    private Long eventId;
    private String title;
    private String description;
    private int maxParticipants;
    private int currentParticipants;
    private String meetingPlace;
    private LocalDate recruitmentDeadline;
    private GroupRecruitStatus status;
    private LocalDateTime createdAt;
}

