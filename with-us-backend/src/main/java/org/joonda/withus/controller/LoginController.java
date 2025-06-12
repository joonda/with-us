/*
 * 로그인 컨트롤러
 * Last Update: 25.06.08
 * */

package org.joonda.withus.controller;

import org.joonda.withus.dto.login.ErrorResponseDto;
import org.joonda.withus.dto.login.LoginDto;
import org.joonda.withus.dto.login.LoginResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDto loginDto) {
        try {
            /*
            * TODO: 하드코딩 테스트 이후에 DB에서 조회하는 걸로 바꿔야함.
            * */
            if ("Test@test.com".equals(loginDto.getEmail()) && "1111".equals(loginDto.getPassword())) {

                LoginResponseDto responseDto = new LoginResponseDto();
                responseDto.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.fake-token");
                responseDto.setMessage("로그인 성공");

                return ResponseEntity.ok(responseDto);
            } else {
                ErrorResponseDto errorResponseDto = new ErrorResponseDto();
                errorResponseDto.setMessage("이메일 또는 비밀번호가 일치하지 않습니다.");

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponseDto);
            }
        } catch (Exception e) {
            ErrorResponseDto errorResponseDto = new ErrorResponseDto();
            errorResponseDto.setMessage("서버 오류가 발생했습니다.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
        }
    }
}
