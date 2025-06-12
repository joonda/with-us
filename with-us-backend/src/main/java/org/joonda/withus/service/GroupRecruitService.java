package org.joonda.withus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joonda.withus.dto.GroupRecruitDto;
import org.joonda.withus.enums.GroupRecruitStatus;
import org.joonda.withus.mapper.GroupRecruitMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupRecruitService {
    private final GroupRecruitMapper groupRecruitMapper;

    public void recruitGroup(GroupRecruitDto groupRecruitDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("recruitGroup authentication name: {}", authentication.getName());

        groupRecruitDto.setAuthorId(1L);
        groupRecruitDto.setCurrentParticipants(1);
        groupRecruitDto.setStatus(GroupRecruitStatus.RECRUITING);
        groupRecruitMapper.recruitGroup(groupRecruitDto);
    }
}
