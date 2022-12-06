package com.epam.hackathon.emotional.help.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class CreateUserDto {

    private String name;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

}
