/*
 * 로그인 에러 응답 메시지 DTO
 * Last Update: 25.06.08
 * */

package org.joonda.withus.dto.login;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private String message;
}
