package org.joonda.withus.controller;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.UserDto;
import org.joonda.withus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        userService.signUp(userDto);
        return ResponseEntity.ok(Map.of("message", "회원가입 성공"));
    }
}