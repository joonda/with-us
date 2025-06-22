/*
 * 회원가입 컨트롤러
 * Last Update: 25.06.08
 * */

package org.joonda.withus.controller;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.UserDto;
import org.joonda.withus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        int result = userService.signUp(userDto);

        if (result == 1) {
            return ResponseEntity.ok(Map.of("message", "회원가입 성공"));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}