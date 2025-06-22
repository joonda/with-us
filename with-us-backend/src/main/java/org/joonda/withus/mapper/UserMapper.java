package org.joonda.withus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.joonda.withus.dto.UserDto;

@Mapper
public interface UserMapper {
    int insertUser(UserDto userDto);

    int isEmailExists(String email);
}
