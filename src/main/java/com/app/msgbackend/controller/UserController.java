package com.app.msgbackend.controller;

import com.app.msgbackend.service.UserService;
import com.app.msgbackend.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Autowired

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path ="/register", consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")

    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel user){
        System.out.println(jwtSecret);
        System.out.println("incoming request");
        System.out.println(user);
        System.out.print(user.toString());
        UserModel registeredUser = userService.RegisterUser(user);
        return ResponseEntity.ok(registeredUser);
    }

}
