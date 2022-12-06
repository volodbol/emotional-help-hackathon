package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.exception.ResourceNotFoundException;
import com.epam.hackathon.emotional.help.model.User;
import com.epam.hackathon.emotional.help.model.dto.CreateUserDto;
import com.epam.hackathon.emotional.help.model.dto.UserDto;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import com.epam.hackathon.emotional.help.service.mapper.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ApplicationUserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();

        if (userList.size() == 0)
            throw new ResourceNotFoundException("Requested resources not found");

        return userList.stream().map(UserConverter::toDto).collect(Collectors.toList());
    }

    public UserDto getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found ( id = " + id + " )");
        }
        return UserConverter.toDto(optionalUser.get());
    }
    public UserDto getByUsername(String username) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found ( username = " + username + " )");
        }
        return UserConverter.toDto(optionalUser.get());
    }

    public UserDto insert(CreateUserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        if (userDto.getPassword().length() < 7 || !userDto.getPassword().equals(userDto.getConfirmPassword()))
            throw new IllegalArgumentException("Password must matches with confirmPassword");

        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);

        return UserConverter.toDto(user);
    }


}
