package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.CreateUserDto;
import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/id/{id}")
    public ResponseEntity<ApplicationUser> findById(@PathVariable Long id) {
        return ResponseEntity.of(userRepository.findById(id));
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApplicationUser> findByUserName(@PathVariable String username) {
        ApplicationUser user = userRepository.findByUsername(username);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<ApplicationUser> createUser(@RequestBody CreateUserDto userDto) {
        ApplicationUser user = new ApplicationUser();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        if (userDto.getPassword().length() < 7 || !userDto.getPassword().equals(userDto.getConfirmPassword()))
            return ResponseEntity.badRequest().build();

        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }
}