package com.app.msgbackend.service;

import com.app.msgbackend.DTO.RecyclingMaterialDTO;
import com.app.msgbackend.model.Materials;
import com.app.msgbackend.model.RecyclingSubmissionsModel;
import com.app.msgbackend.model.UserModel;
import com.app.msgbackend.repository.RecyclingSubmissionRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class RecyclingSubmissionService {
    private final RecyclingSubmissionRepository repository;

    public void addSubmission(Optional<UserModel> user, RecyclingMaterialDTO dto){
        System.out.println("IN THE SERVICE!!!");
        RecyclingSubmissionsModel submission = new RecyclingSubmissionsModel();
        UserModel optUser = user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        System.out.println(dto + " DTO IS HERE!");

        submission.setUser(optUser);
        submission.setMaterials(dto.getMaterials());
        submission.setQuantity(dto.getQuantity());
        submission.setQuantityType(dto.getQuantityType());
        repository.save(submission);
    }

    public List<RecyclingSubmissionsModel> getAllSubmissionsByUser(UserModel user){
        return repository.findByUser(user);
    }
}
