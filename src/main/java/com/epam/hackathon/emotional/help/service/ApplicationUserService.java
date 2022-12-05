package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.dto.ApplicationUserCreationDto;
import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {
    private final ApplicationUserRepository applicationUserRepository;

    private final PasswordEncoder passwordEncoder;


    public Optional<ApplicationUser> findUserById(Long id) {
        return applicationUserRepository.findById(id);
    }

    public Optional<ApplicationUser> findUserByUuid(String uuid) {
        return applicationUserRepository.findByUuid(uuid);
    }

    public ApplicationUser saveApplicationUser(ApplicationUserCreationDto userCreationDto) {
        ApplicationUser applicationUser = ApplicationUser.builder()
                .username(userCreationDto.getUsername())
                .password(passwordEncoder.encode(userCreationDto.getPassword()))
                .build();
        return applicationUserRepository.save(applicationUser);
    }

    public ApplicationUser saveApplicationUser(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }

    public Optional<ApplicationUser> verifyUser(String username, String password) {
        return applicationUserRepository.findByUsername(username)
                .filter(applicationUser -> passwordEncoder.matches(password, applicationUser.getPassword()));
    }

}
