package com.epam.hackathon.emotional.help.service.mapper;

import com.epam.hackathon.emotional.help.model.User;
import com.epam.hackathon.emotional.help.model.dto.CreateUserDto;
import com.epam.hackathon.emotional.help.model.dto.UserDto;

public class UserConverter {
    public static UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }
    public static User toEntity(CreateUserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
