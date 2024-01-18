package com.app.msgbackend.repository;

import com.app.msgbackend.model.RecyclingCenterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingCenterRepository extends JpaRepository<RecyclingCenterModel, Long> {
}
