package com.epam.hackathon.emotional.help.configuration;

import com.epam.hackathon.emotional.help.filter.UUIDAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfiguration {
    private static final String PUBLIC_URLS = "/users";
    private static final RequestMatcher PROTECTED_URLS = new AntPathRequestMatcher("/questionnaires/**");
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests((req) -> req
                        .antMatchers(PUBLIC_URLS).permitAll())
                .addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class)
                .csrf().disable()
                .httpBasic().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UUIDAuthenticationFilter restAuthenticationFilter() {
        return new UUIDAuthenticationFilter(PROTECTED_URLS);
    }
}
