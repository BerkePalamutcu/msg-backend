package com.app.msgbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "recycling_submissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecyclingSubmissionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long submissionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserModel user;

    @Enumerated(EnumType.STRING)
    Materials materials;

    private Double quantity;

    @Enumerated(EnumType.STRING)
    private  QuantityType quantityType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

}
