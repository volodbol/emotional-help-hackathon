package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.ApplicationUserCreationDto;
import com.epam.hackathon.emotional.help.exception.UsernameOrPasswordIncorrectException;
import com.epam.hackathon.emotional.help.service.ApplicationUserService;
import com.epam.hackathon.emotional.help.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserAuthenticationService userAuthenticationService;

    private final ApplicationUserService applicationUserService;

    @PostMapping("sign-in")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userAuthenticationService.login(username, password)
                .orElseThrow(() -> new UsernameOrPasswordIncorrectException("Invalid login and/or password"));
    }

    @PostMapping("sign-up")
    public String register(@RequestBody ApplicationUserCreationDto userDto) {
        applicationUserService.saveApplicationUser(userDto);
        return login(userDto.getUsername(), userDto.getPassword());
    }

}
