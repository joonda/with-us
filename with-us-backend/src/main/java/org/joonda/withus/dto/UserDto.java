package org.joonda.withus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long userId;
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private String email;
    private String password;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String gender;
    private LocalDateTime createdAt;
}
