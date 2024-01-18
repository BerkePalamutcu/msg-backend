package com.app.msgbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "recycling_centers")
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecyclingCenterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String operatingHours;

    @Transient
    private String location; // it is not needed to register in the db unless stated otherwise.

    @ElementCollection
    @Column(name = "material")
    @CollectionTable(name = "accepted_materials")
    private Set<String> acceptedMaterials;

}
