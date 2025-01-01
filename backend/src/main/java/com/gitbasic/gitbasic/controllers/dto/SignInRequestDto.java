package com.gitbasic.gitbasic.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignInRequestDto {
    private String username;
    private String password;
}
