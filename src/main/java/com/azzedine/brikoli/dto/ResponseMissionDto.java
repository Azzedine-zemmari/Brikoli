package com.azzedine.brikoli.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.azzedine.brikoli.enums.Urgency;

public record ResponseMissionDto(Long id, String title, String description, Double budgetMin, Double budgetMax,
        String location, Urgency urgency, String imageName, String category, LocalDateTime created_at , String firstName, String lastName,
        int missionNumber) {
}
