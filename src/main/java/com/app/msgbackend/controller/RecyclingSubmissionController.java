package com.app.msgbackend.controller;

import com.app.msgbackend.DTO.RecyclingMaterialDTO;
import com.app.msgbackend.DTO.RecyclingSubmissionListDTO;
import com.app.msgbackend.model.RecyclingSubmissionsModel;
import com.app.msgbackend.model.UserModel;
import com.app.msgbackend.service.RecyclingSubmissionService;
import com.app.msgbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycling-submission")
@RequiredArgsConstructor
public class RecyclingSubmissionController {
    private final RecyclingSubmissionService service;
    private final UserService userService;
    @PostMapping(path = "/addSubmission")
    public ResponseEntity<?> addSubmission(@RequestBody RecyclingSubmissionListDTO submissionListDTO){
        System.out.println("IN THE POST CONTROLLER");
        System.out.println(submissionListDTO + "SUBMISSION LIST CONTROLLER");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<UserModel> user = Optional.ofNullable(userService.findByEmail(username));

        if(user.isPresent()){
            for(RecyclingMaterialDTO submission : submissionListDTO.getSubmissions()){
                service.addSubmission(user, submission);
            }

        }

        return ResponseEntity.ok("All materials added successfully");
    }

    @GetMapping(path = "/getSubmissionsByUser")
    public ResponseEntity<List<RecyclingSubmissionsModel>> getAllContributionsByUser(@RequestParam String userEmail){

        Optional<UserModel> user = Optional.ofNullable(userService.findByEmail(userEmail));

        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<RecyclingSubmissionsModel> submissions = service.getAllSubmissionsByUser(user.get());
        return ResponseEntity.ok(submissions);
    }
}
