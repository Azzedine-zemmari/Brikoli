package com.azzedine.brikoli.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.azzedine.brikoli.enums.MissionStatus;
import com.azzedine.brikoli.enums.Urgency;

public record MissionRequestDto(String title , String description , String location , Long client_id, Long category_id,Urgency urgency , MissionStatus missionStatus , Double budget_max , Double budget_min , LocalDate  mission_date , LocalDateTime created_at
){};
