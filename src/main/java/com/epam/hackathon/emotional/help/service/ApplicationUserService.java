package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.dto.ApplicationUserCreationDto;
import com.epam.hackathon.emotional.help.exception.EmailNotAvailableException;
import com.epam.hackathon.emotional.help.exception.PasswordNotValidException;
import com.epam.hackathon.emotional.help.exception.UsernameNotAvailableException;
import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {

    private static final int MIN_PASSWORD_LENGTH = 7;

    private final ApplicationUserRepository applicationUserRepository;

    private final PasswordEncoder passwordEncoder;


    public Optional<ApplicationUser> findUserById(Long id) {
        return applicationUserRepository.findById(id);
    }

    public Optional<ApplicationUser> findUserByUuid(String uuid) {
        return applicationUserRepository.findByUuid(uuid);
    }

    public ApplicationUser saveApplicationUser(ApplicationUserCreationDto userCreationDto) {
        isUsernameAvailable(userCreationDto.getUsername());
        isEmailAvailable(userCreationDto.getEmail());
        isPasswordValid(userCreationDto.getPassword());
        ApplicationUser applicationUser = ApplicationUser.builder()
                .username(userCreationDto.getUsername())
                .password(passwordEncoder.encode(userCreationDto.getPassword()))
                .email(userCreationDto.getEmail())
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

    private void isUsernameAvailable(String username) {
        if (applicationUserRepository.existsByUsername(username)) {
            throw new UsernameNotAvailableException("Username '" + username + "' is taken");
        }
    }

    private void isEmailAvailable(String email) {
        if (applicationUserRepository.existsByEmail(email)) {
            throw new EmailNotAvailableException("Email '" + email + "' is taken");
        }
    }

    private static void isPasswordValid(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new PasswordNotValidException("Password must be at least 7 characters");
        }
    }

}
