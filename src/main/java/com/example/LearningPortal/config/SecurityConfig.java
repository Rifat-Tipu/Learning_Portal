package com.example.LearningPortal.config;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//swagger- http://localhost:8080/swagger-ui/index.html

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("password1")
                .roles("STUDENT")
                .build();

        UserDetails instructor = User.withDefaultPasswordEncoder()
                .username("instructor")
                .password("password3")
                .roles("INSTRUCTOR")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password2")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(student,instructor,admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/portal/admin/**","/portal/category/**").hasRole("ADMIN")
                        .requestMatchers("/portal/student/**","/portal/review/**","/portal/payment/**").hasAnyRole("STUDENT", "ADMIN")
                        .requestMatchers("/portal/instructor/**","/portal/course/**","/portal/lesson/**").hasAnyRole("INSTRUCTOR", "ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}