package com.azzedine.brikoli.services.mission;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.mapper.MissionDtoMapper;
import com.azzedine.brikoli.repository.CategoryRepository;
import com.azzedine.brikoli.repository.ClientRepository;
import com.azzedine.brikoli.repository.MissionRepository;
import com.azzedine.brikoli.entity.Category;
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
    private final CategoryRepository categoryRepository;
    @Override
    public MissionRequestDto createMission(MissionRequestDto dto){
        Mission mission = missionDtoMapper.dtoToMission(dto);

        ClientProfile client = clientRepository.findById(dto.client_id()).orElseThrow(() -> new RuntimeException("client not found"));

        Category category = categoryRepository.findById(dto.category_id()).orElseThrow(() -> new RuntimeException("category not found"));

        mission.setClient(client);
        mission.setCategory(category);
        mission.setCreated_at(LocalDateTime.now());

        missionRepository.save(mission);

        MissionRequestDto result = missionDtoMapper.entityToDto(mission);
        return result;
    }
}
