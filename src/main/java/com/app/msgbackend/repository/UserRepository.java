package com.app.msgbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.msgbackend.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
