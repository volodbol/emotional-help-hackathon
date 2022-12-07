package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.ApplicationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UUIDAuthenticationService implements UserAuthenticationService {

    private final ApplicationUserService applicationUserService;

    @Override
    public Optional<String> login(String username, String password) {
        Optional<ApplicationUser> userOptional = applicationUserService.verifyUser(username, password);
        String uuid = null;
        if (userOptional.isPresent()) {
            ApplicationUser applicationUser = userOptional.get();
            uuid = UUID.randomUUID().toString();
            applicationUser.setUuid(uuid);
            applicationUserService.saveApplicationUser(applicationUser);
        }
        return Optional.ofNullable(uuid);
    }

    @Override
    public Optional<ApplicationUser> findByToken(String token) {
        return applicationUserService.findUserByUuid(token);
    }

    @Override
    public void logout(ApplicationUser user) {
        user.setUuid(null);
        applicationUserService.saveApplicationUser(user);
    }
}
