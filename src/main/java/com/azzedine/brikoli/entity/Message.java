package com.azzedine.brikoli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime sentAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id",nullable = false)
    private Mission mission;

    // the sender can be either a client or a professional
    // no receiver to avoid duplication
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_sender_id")
    private ClientProfile client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="professional_sender_id")
    private ProfessionalProfile professional;



}
