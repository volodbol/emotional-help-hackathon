package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.dto.ApplicationUserDto;
import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {
    private final ApplicationUserRepository applicationUserRepository;

    private final PasswordEncoder passwordEncoder;


    public Optional<ApplicationUser> findUserById(Long id) {
        return applicationUserRepository.findById(id);
    }

    public ApplicationUser saveApplicationUser(ApplicationUserDto applicationUserDto) {
        ApplicationUser applicationUser = new ApplicationUser();
        BeanUtils.copyProperties(applicationUserDto, applicationUser);
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        applicationUser.setUuid(UUID.randomUUID().toString());
        return applicationUserRepository.save(applicationUser);
    }

    public Optional<ApplicationUser> verifyUser(String username, String password) {
        Optional<ApplicationUser> userFromRepository = applicationUserRepository.findByUsername(username);
        Optional<ApplicationUser> user = userFromRepository.filter((u) -> passwordEncoder.matches(password, u.getPassword()));
        user.ifPresent((u) -> {
            u.setUuid(UUID.randomUUID().toString());
            updateUUID(u);
        });
        return user;
    }

    private void updateUUID(ApplicationUser user) {
        applicationUserRepository.updateUuidByUsername(user.getUuid(), user.getUsername());
    }

    public void deleteUUID(String UUID) {
        applicationUserRepository.updateUuidByUuid(UUID, null);
    }

    public boolean isUuidExist(String uuid) {
        return applicationUserRepository.existsByUuid(uuid);
    }

}
