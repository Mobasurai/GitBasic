package com.gitbasic.gitbasic.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfileAddInfoDto {
    String name = "";
    String bio = "";
    String image = "";
    String birthday = "";
    String gender = "";
    String phone = "";
    String organization = "";
    String location = "";
    String website = "";
    String social1 = "";
    String social2 = "";
    String social3 = "";
    String social4 = "";
}
