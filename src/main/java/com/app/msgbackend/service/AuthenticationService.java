package com.app.msgbackend.service;

import com.app.msgbackend.controller.AuthenticationResponse;
import com.app.msgbackend.controller.RegisterRequest;
import com.app.msgbackend.model.Role;
import com.app.msgbackend.model.UserModel;
import com.app.msgbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.msgbackend.controller.AuthRequest;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public ResponseEntity<?> register(RegisterRequest request){
        if(repository.existsByEmail(request.getEmail())){
            return ResponseEntity.badRequest().body("Error: the submitted email is already registered");
        }
        var user = UserModel.builder()
                .email(request.getEmail())
                .name(request.getName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);
        return ResponseEntity.ok("Success");
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();

    }

    public ResponseEntity<?> authenticate(AuthRequest request){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            var user = repository.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return ResponseEntity.ok(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .email(user.getEmail())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .role(String.valueOf(user.getRole()))
                    .address(user.getAddress())
                    .build());
        } catch(AuthenticationException e){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
