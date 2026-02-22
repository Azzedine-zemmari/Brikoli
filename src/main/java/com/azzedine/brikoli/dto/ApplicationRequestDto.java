package com.azzedine.brikoli.dto;

import java.time.LocalDateTime;

import com.azzedine.brikoli.controller.Mission;
import com.azzedine.brikoli.entity.ProfessionalProfile;
import com.azzedine.brikoli.enums.StatusApplication;

public record ApplicationRequestDto(
    Long missionId,
    String message,
    Double proposedPrice
) {}