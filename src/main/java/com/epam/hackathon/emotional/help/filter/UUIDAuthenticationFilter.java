package com.epam.hackathon.emotional.help.filter;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class UUIDAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String BEARER = "Bearer";

    public UUIDAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Optional<String> param = Optional.ofNullable(request.getHeader(AUTHORIZATION));
        String token = param
                .map(string -> string.substring(BEARER.length()))
                .map(String::trim)
                .orElseThrow(() -> new BadCredentialsException("Invalid Authentication Token"));

        Authentication auth = new UsernamePasswordAuthenticationToken(token, token);
        return getAuthenticationManager().authenticate(auth);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

}
