package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.ApplicationUser;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    public ApplicationUser findUserByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }

    public ApplicationUser addUser(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }
}
