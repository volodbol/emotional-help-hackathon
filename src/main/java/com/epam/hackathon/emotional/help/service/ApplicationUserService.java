package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.User;
import com.epam.hackathon.emotional.help.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;


    public Optional<User> findUserById(Long id) {
        return applicationUserRepository.findById(id);
    }

}
