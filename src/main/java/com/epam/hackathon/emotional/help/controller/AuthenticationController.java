package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.ApplicationUserCreationDto;
import com.epam.hackathon.emotional.help.exception.UsernameOrPasswordIncorrectException;
import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.model.EmotionalMap;
import com.epam.hackathon.emotional.help.service.ApplicationUserService;
import com.epam.hackathon.emotional.help.service.EmotionalMapService;
import com.epam.hackathon.emotional.help.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserAuthenticationService userAuthenticationService;

    private final ApplicationUserService applicationUserService;

    private final EmotionalMapService emotionalMapService;

    @PostMapping("sign-in")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userAuthenticationService.login(username, password)
                .orElseThrow(() -> new UsernameOrPasswordIncorrectException("Invalid login and/or password"));
    }

    @PostMapping("sign-up")
    public String register(@RequestBody ApplicationUserCreationDto userDto, @RequestParam String anonymousUuid) {
        ApplicationUser applicationUser = applicationUserService.saveApplicationUser(userDto);
        emotionalMapService.findEmotionalMapById(anonymousUuid)
                .ifPresent((EmotionalMap emotionalMap) -> {
                    emotionalMap.setApplicationUser(applicationUser);
                    emotionalMapService.saveEmotionalMap(emotionalMap);
                });
        return login(userDto.getUsername(), userDto.getPassword());
    }

}
