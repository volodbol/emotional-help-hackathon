package com.epam.hackathon.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationUserDto {

    private String username;

    private String password;

    private String email;
}
