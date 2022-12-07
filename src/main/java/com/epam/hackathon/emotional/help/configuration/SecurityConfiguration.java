package com.epam.hackathon.emotional.help.configuration;

import com.epam.hackathon.emotional.help.filter.UUIDAuthenticationFilter;
import com.epam.hackathon.emotional.help.security.TokenAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/users/**")
    );

    private static final RequestMatcher PUBLIC_URLS = new NegatedRequestMatcher(PROTECTED_URLS);

    private final TokenAuthenticationProvider tokenAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(tokenAuthenticationProvider)
                .authenticationManager(authenticationManager())
                .sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and()
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(forbidden(), PROTECTED_URLS)
                .and()
                .addFilterBefore(authenticationFilter(), AnonymousAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(PROTECTED_URLS).authenticated()
                .requestMatchers(PUBLIC_URLS).permitAll()
                .and()
                .cors().and()
                .csrf().disable()
                .httpBasic().disable()
                .logout().disable();
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager() {
        return new ProviderManager(tokenAuthenticationProvider);
    }

    @Bean
    UUIDAuthenticationFilter authenticationFilter() {
        UUIDAuthenticationFilter filter = new UUIDAuthenticationFilter(PROTECTED_URLS);
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(
                (HttpServletRequest request, HttpServletResponse response, Authentication authentication) -> {
                }
        );
        return filter;
    }

    @Bean
    AuthenticationEntryPoint forbidden() {
        return new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
    }

}
