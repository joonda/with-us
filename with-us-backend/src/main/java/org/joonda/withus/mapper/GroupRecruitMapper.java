/*
 * 동행 모집 관련 Mapper
 * Last Update: 25.06.12
 * */

package org.joonda.withus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.joonda.withus.dto.GroupRecruitDto;

import java.util.List;

@Mapper
public interface GroupRecruitMapper {
    void recruitGroup(GroupRecruitDto groupRecruitDto);

    List<GroupRecruitDto> groupRecruitList();
}
