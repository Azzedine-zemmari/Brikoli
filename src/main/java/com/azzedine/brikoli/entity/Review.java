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
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    private String comment;

    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private ProfessionalProfile professional;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientProfile client;

}
