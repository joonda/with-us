/*
 * 로그인 DTO
 * Last Update: 25.06.08
 * */

package org.joonda.withus.dto.login;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
