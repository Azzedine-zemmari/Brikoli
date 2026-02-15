package com.azzedine.brikoli.services.mission;
import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.enums.MissionStatus;

import java.util.List;

public interface MissionService {
    MissionRequestDto createMission(MissionRequestDto dto);
    List<MissionRequestDto> showAll();
    List<MissionRequestDto> showUserMissions(String email);
    void modifierMission(Long id,MissionRequestDto dto);
    Long countMission(MissionStatus status);
}
