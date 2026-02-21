package com.azzedine.brikoli.services.mission;
import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.dto.ResponseMissionDto;
import com.azzedine.brikoli.enums.MissionStatus;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface MissionService {
public MissionRequestDto createMission(MissionRequestDto dto, MultipartFile image);
    List<MissionRequestDto> showAll();
    List<MissionRequestDto> showUserMissions(String email);
    void modifierMission(Long id,MissionRequestDto dto);
    Long countMission(MissionStatus status);
    ResponseMissionDto missionDetails(Long id);
}
