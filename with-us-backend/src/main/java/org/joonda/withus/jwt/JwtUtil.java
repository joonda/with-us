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

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private long expirationTime;

  private Key key;

  @PostConstruct
  public void init() {
    key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String generateToken(String email) {
    return Jwts.builder()
              .setSubject(email)
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
              .signWith(key, SignatureAlgorithm.HS256)
              .compact();
  }

  public String extractEmail(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build()
          .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
      return false;
    }
  }
}
