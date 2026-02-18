package com.azzedine.brikoli.entity;

import com.azzedine.brikoli.enums.MissionStatus;
import com.azzedine.brikoli.enums.Urgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Double budgetMin;

    private Double budgetMax;
    
    private String location;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    private LocalDateTime created_at;

    @OneToMany(mappedBy = "mission")
    private List<Review> review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientProfile client;

    @OneToMany(mappedBy = "mission")
    private List<Application> applications;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "mission")
    private List<Message> messages;

    private LocalDate missionDate;
}
