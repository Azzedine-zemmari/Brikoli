package com.azzedine.brikoli.services.mission;

import org.springframework.stereotype.Service;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.mapper.MissionDtoMapper;
import com.azzedine.brikoli.repository.ClientRepository;
import com.azzedine.brikoli.repository.MissionRepository;
import com.azzedine.brikoli.entity.ClientProfile;
import com.azzedine.brikoli.entity.Mission;
import com.azzedine.brikoli.entity.ClientProfile;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;
    private final MissionDtoMapper missionDtoMapper;
    private final ClientRepository clientRepository;
    @Override
    public  void createMission(MissionRequestDto dto){
        Mission mission = missionDtoMapper.dtoToMission(dto);

        ClientProfile client = clientRepository.findById(dto.client_id()).orElseThrow(()=> new RuntimeException("client not found"));

        // todo: i need category repository 

    }
}
