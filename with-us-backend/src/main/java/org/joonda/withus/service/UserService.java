package org.joonda.withus.service;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.UserDto;
import org.joonda.withus.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public int signUp(UserDto userDto) {
        LocalDateTime now = LocalDateTime.now();
        userDto.setCreatedAt(now);

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        userDto.setEmail(userDto.getEmail().toLowerCase());
        return userMapper.insertUser(userDto);
    }

    public boolean isEmailExists(String email) {
        return userMapper.isEmailExists(email) > 0;
    }
}
