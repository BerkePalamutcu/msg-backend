package com.app.msgbackend.controller;

import com.app.msgbackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class AuthController {
    private final AuthenticationService service;
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        System.out.println(request);
        return ResponseEntity.ok(service.register(request));
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthRequest request){
        System.out.println(request + " auth request");
        return ResponseEntity.ok(service.authenticate(request));
    }
}
