package com.gitbasic.gitbasic.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
