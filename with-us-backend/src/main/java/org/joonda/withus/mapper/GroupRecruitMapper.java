/*
 * 동행 모집 관련 Mapper
 * Last Update: 25.06.12
 * */

package org.joonda.withus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.joonda.withus.dto.GroupRecruitDto;
import org.springframework.http.ResponseEntity;

@Mapper
public interface GroupRecruitMapper {
    void recruitGroup(GroupRecruitDto groupRecruitDto);
}
