/*
 * 로그인 컨트롤러
 * Last Update: 25.06.08
 * */

package org.joonda.withus.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joonda.withus.dto.login.ErrorResponseDto;
import org.joonda.withus.dto.login.LoginDto;
import org.joonda.withus.dto.login.LoginResponseDto;
import org.joonda.withus.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDto loginDto) {
        try {

            LoginResponseDto loginResponseDto = loginService.login(loginDto);
            return ResponseEntity.ok(loginResponseDto);

        } catch (IllegalArgumentException e) {
            ErrorResponseDto errorResponseDto = new ErrorResponseDto();
            log.error("Login Error: {}", e.getMessage());
            errorResponseDto.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponseDto);

        } catch (Exception e) {
            ErrorResponseDto errorResponseDto = new ErrorResponseDto();
            log.error("Login Error: {}", e.getMessage());
            errorResponseDto.setMessage("서버 오류가 발생했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);

        }
    }
}
