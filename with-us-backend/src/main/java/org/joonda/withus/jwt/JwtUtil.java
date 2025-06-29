package org.joonda.withus.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

  // signature를 만들기 위한 secret
  @Value("${jwt.secret}")
  private String secret;

  // 세션 만료 시간
  @Value("${jwt.expiration}")
  private long expirationTime;

  // JWT 서명에 사용할 Key 객체 변수 선언
  private Key key;

  // secret 문자열을 Key 객체로 변환
  @PostConstruct
  public void init() {
    key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String generateToken(String email) {
    return Jwts.builder()
              .setSubject(email) // Token payload에 email을 subject로 설정
              .setIssuedAt(new Date()) // 발급 시간 추가
              .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 만료 시간 추가
              .signWith(key, SignatureAlgorithm.HS256) // HS256 알고리즘으로 서명을 생성
              .compact();
  }

  public String extractEmail(String token) {
    return Jwts.parserBuilder() // 토큰 parser 생성
            .setSigningKey(key) // 검증용 key 설정
            .build() // parser build
            .parseClaimsJws(token) // token을 parsing + validation
            .getBody() // payload 에서 email 추출 후 반환
            .getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
      return false;
    }
  }
}
