package com.epam.hackathon.emotional.help.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String username;
    private String password;
    private String email;
}
