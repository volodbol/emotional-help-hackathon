package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.ApplicationUser;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username account username
     * @param password account password
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<String> login(String username, String password);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return an {@link Optional} of a user when found
     */
    Optional<ApplicationUser> findByToken(String token);

    /**
     * Logs out the given input {@code user}.
     *
     * @param user the user to logout
     */
    void logout(ApplicationUser user);

}
