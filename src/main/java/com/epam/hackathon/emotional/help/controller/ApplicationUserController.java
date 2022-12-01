package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.ApplicationUserDto;
import com.epam.hackathon.emotional.help.exception.UsernameOrPasswordIncorrectException;
import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    @PostMapping("sign-in")
    public String login(@RequestParam String username, @RequestParam String password) {
        Optional<ApplicationUser> user = applicationUserService.verifyUser(username, password);
        return user.orElseThrow(
                () -> new UsernameOrPasswordIncorrectException("Username or password incorrect")
        ).getUuid();
    }

    @PostMapping("sign-up")
    public String saveApplicationUser(@RequestParam ApplicationUserDto userDto) {
        ApplicationUser applicationUser = applicationUserService.saveApplicationUser(userDto);
        return applicationUser.getUuid();
    }

    @PostMapping("logout")
    public void logout(@RequestParam String UUID) {
        applicationUserService.deleteUUID(UUID);
    }
}
