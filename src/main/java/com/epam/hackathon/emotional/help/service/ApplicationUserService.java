package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    public Optional<ApplicationUser> findUserByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }

    public ApplicationUser addUser(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }

    public boolean updateUserById(ApplicationUser user) {
        Optional<ApplicationUser> userFromRepository = applicationUserRepository.findById(user.getId());
        if (userFromRepository.isEmpty()) {
            return false;
        }
        ApplicationUser userToUpdate = userFromRepository.get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        applicationUserRepository.save(userToUpdate);
        return true;
    }

    public void deleteUser(Long id) {
        applicationUserRepository.deleteById(id);
    }
}
