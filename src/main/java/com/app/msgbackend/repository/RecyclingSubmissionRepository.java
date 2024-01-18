package com.app.msgbackend.repository;

import com.app.msgbackend.model.RecyclingSubmissionsModel;
import com.app.msgbackend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecyclingSubmissionRepository extends JpaRepository<RecyclingSubmissionsModel, Long> {
    List<RecyclingSubmissionsModel> findByUserId(Long userId);

    List<RecyclingSubmissionsModel> findByUser(UserModel user);
}
