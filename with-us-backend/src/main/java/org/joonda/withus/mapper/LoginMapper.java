package org.joonda.withus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.joonda.withus.dto.login.LoginDto;

@Mapper
public interface LoginMapper {
  LoginDto findEmail(@Param("email") String email);
}
