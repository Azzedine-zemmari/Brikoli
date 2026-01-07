package com.azzedine.brikoli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String bio;

   @ManyToMany
   @JoinTable(
           name="professional_skills",
           joinColumns = @JoinColumn(name = "professional_id"),
           inverseJoinColumns = @JoinColumn(name="skills_id")
   )
    private List<Skill> Skills;

   private String Location;

   private Boolean isGraduated;

   private Double ratingAverage;

   private Integer completedMission;

   @OneToOne
   @JoinColumn(name="user_id")
   private User user;

   @OneToMany(mappedBy = "professional")
    private List<Review> reviews;
}
