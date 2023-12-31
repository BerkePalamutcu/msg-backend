package com.app.msgbackend.model;

import jakarta.persistence.*;

import lombok.ToString;
import lombok.Data;
@Entity
@Table(name = "users")
@ToString
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password; //hashed
    private String name;
    private String lastName;
    private String address;

}
