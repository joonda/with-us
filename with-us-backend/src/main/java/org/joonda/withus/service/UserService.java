package org.joonda.withus.service;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.UserDto;
import org.joonda.withus.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void signUp(UserDto userDto) {
        userMapper.insertUser(userDto);
    }
}
