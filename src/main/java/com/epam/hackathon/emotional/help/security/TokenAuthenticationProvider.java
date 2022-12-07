package com.epam.hackathon.emotional.help.security;

import com.epam.hackathon.emotional.help.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final UserAuthenticationService userAuthenticationService;

    @Override
    protected void additionalAuthenticationChecks(
            UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // TODO it's not required
    }

    @Override
    protected UserDetails retrieveUser(
            String username,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        Object token = authentication.getCredentials();
        return Optional.ofNullable(token)
                .map(String::valueOf)
                .flatMap(userAuthenticationService::findByToken)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
    }
}
