package com.aijobtracker.backend.service;

import com.aijobtracker.backend.exception.ResourceNotFoundException;
import com.aijobtracker.backend.model.User;
import com.aijobtracker.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProvider {

    private final UserRepository userRepository;

    public User getDefaultUser() {
        return userRepository.findByEmail("charan@test.com")
                .orElseThrow(() -> new ResourceNotFoundException("Test user not found"));
    }
}
