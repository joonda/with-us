package org.joonda.withus.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String gender;
    private LocalDateTime createdAt;
}
