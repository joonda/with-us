/*
 * 로그인 성공 시, 토큰 및 메시지 반환 DTO
 * Last Update: 25.06.08
 * */

package org.joonda.withus.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;
    private String message;
}
