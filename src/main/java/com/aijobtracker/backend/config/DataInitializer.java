package com.aijobtracker.backend.config;

import com.aijobtracker.backend.model.User;
import com.aijobtracker.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("charan@test.com")) {
            userRepository.save(
                    User.builder()
                            .firstName("Charan")
                            .lastName("K")
                            .email("charan@test.com")
                            .password("dummy")
                            .build()
            );
        }
    }
}
