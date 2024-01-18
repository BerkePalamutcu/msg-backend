package com.app.msgbackend.service;

import com.app.msgbackend.model.UserModel;
import com.app.msgbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //this is done just to abstract userRepository in the controller layer.
    public UserModel findByEmail(String email) {
        Optional<UserModel> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
