package org.joonda.withus.service;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.login.LoginDto;
import org.joonda.withus.dto.login.LoginResponseDto;
import org.joonda.withus.jwt.JwtUtil;
import org.joonda.withus.mapper.LoginMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final LoginMapper loginMapper;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public LoginResponseDto login(LoginDto loginDto) {
    LoginDto user = loginMapper.findEmail(loginDto.getEmail());
    if (user == null || !passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
    }

    String token = jwtUtil.generateToken(loginDto.getEmail());

    LoginResponseDto response = new LoginResponseDto();
    response.setMessage("로그인 성공");
    response.setToken(token);

    return response;
  }
}
