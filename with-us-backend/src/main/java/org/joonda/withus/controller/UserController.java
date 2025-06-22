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
import java.util.regex.Pattern;

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

    // TODO: API response 공통 응답 만들기!
    @GetMapping("/emailCheck")
    public ResponseEntity<?> isEmailExists(@RequestParam String email) {

        if (email == null || email.isEmpty() || !EMAIL_PATTERN.matcher(email).matches()) {
            return ResponseEntity.badRequest().build();
        }

        boolean result = userService.isEmailExists(email.toLowerCase());
        
        if (result) {
            return ResponseEntity.ok(Map.of("exists", true, "message", "이미 사용중인 이메일입니다."));
        } else {
            return ResponseEntity.ok(Map.of("exists", false, "message", "사용 가능한 이메일입니다."));
        }
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
      "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );
}