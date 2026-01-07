package com.azzedine.brikoli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "mission_id")
)
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    private String comment;

    private LocalDateTime created_at;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mission_id",nullable = false)
    private Mission mission;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "professional_id",nullable = false)
    private ProfessionalProfile professional;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id",nullable = false)
    private ClientProfile client;


}
