package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@CrossOrigin
@RequiredArgsConstructor
public class ApplicationUserController {

    private final UserAuthenticationService userAuthenticationService;

    @GetMapping("current")
    public ApplicationUser current(@AuthenticationPrincipal ApplicationUser applicationUser) {
        return applicationUser;
    }

    @GetMapping("logout")
    public boolean logout(@AuthenticationPrincipal ApplicationUser applicationUser) {
        userAuthenticationService.logout(applicationUser);
        return true;
    }

}
