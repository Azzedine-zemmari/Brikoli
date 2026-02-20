package com.azzedine.brikoli.services.mission;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.mapper.MissionDtoMapper;
import com.azzedine.brikoli.repository.CategoryRepository;
import com.azzedine.brikoli.repository.ClientRepository;
import com.azzedine.brikoli.repository.MissionRepository;
import com.azzedine.brikoli.repository.UserRepository;

import io.micrometer.observation.annotation.ObservationKeyValue;

import com.azzedine.brikoli.entity.Category;
import com.azzedine.brikoli.entity.ClientProfile;
import com.azzedine.brikoli.entity.Mission;
import com.azzedine.brikoli.enums.MissionStatus;
import com.azzedine.brikoli.entity.ClientProfile;
import com.azzedine.brikoli.entity.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;
    private final MissionDtoMapper missionDtoMapper;
    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    
    @Override
    public MissionRequestDto createMission(MissionRequestDto dto,MultipartFile image){
        Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User authenticatedUser = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found")); 

        ClientProfile client = clientRepository.findByUserId(authenticatedUser.getId())
            .orElseThrow(() -> new RuntimeException("Client not found"));
        
        Mission mission = missionDtoMapper.dtoToMission(dto);


        Category category = categoryRepository.findById(dto.category_id()).orElseThrow(() -> new RuntimeException("category not found"));

        mission.setClient(client);
        mission.setCategory(category);
        if(dto.budget_max() < dto.budget_min()){
            throw new IllegalArgumentException("min budget has to be smaller then max budget");
        }
        if(dto.mission_date().isBefore(LocalDate.now())){
                throw new IllegalArgumentException("Mission date cannot be in the past");
        }

       if (image != null && !image.isEmpty()) {
    try {
        String uploadDir = "uploads/";
        String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);

        Files.createDirectories(filePath.getParent());
        Files.write(filePath, image.getBytes());

        mission.setImageName(fileName);

    } catch (IOException e) {
        throw new RuntimeException("Failed to store image", e);
    }
}


        mission.setMissionDate(dto.mission_date());
        mission.setCreated_at(LocalDateTime.now());
        mission.setMissionStatus(MissionStatus.POSTED);

        missionRepository.save(mission);

        MissionRequestDto result = missionDtoMapper.entityToDto(mission);
        return result;
    }

    // for admin
    @Override
    public List<MissionRequestDto> showAll(){
        return missionRepository.findAll()
        .stream()
        .map(missionDtoMapper::entityToDto)
        .toList();
    }

    @Override
    public List<MissionRequestDto> showUserMissions(String email){

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    return missionRepository.findByClientUserId(user.getId())
            .stream()
            .map(missionDtoMapper::entityToDto)
            .toList();
    }

    @Override
    public void modifierMission(Long id,MissionRequestDto dto){
        Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User authenticatedUser = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found")); 

        ClientProfile client = clientRepository.findByUserId(authenticatedUser.getId())
            .orElseThrow(() -> new RuntimeException("Client not found"));
            
        Mission mission = missionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mission not found"));

        
        if(!mission.getClient().getId().equals(client.getId())){
            throw new RuntimeException("You are not allowed to modify this mission");
        }
        
        mission.setTitle(dto.title());
        mission.setDescription(dto.description());
        mission.setLocation(dto.location());
        mission.setUrgency(dto.urgency());
        mission.setMissionStatus(MissionStatus.POSTED);
        mission.setBudgetMax(dto.budget_max());
        mission.setBudgetMin(dto.budget_min());

        if(dto.category_id() != null){
            Category category = categoryRepository.findById(dto.category_id())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            mission.setCategory(category);
        }

        missionRepository.save(mission);
    }

    @Override
    public Long countMission(MissionStatus status){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        ClientProfile client = clientRepository
            .findByUserId(user.getId())
            .orElseThrow(() -> new RuntimeException("Client profile not found"));

        return missionRepository
            .countByMissionStatusAndClientId(status, client.getId());
    }
    @Override
    public MissionRequestDto missionDetails(Long id){
        Mission mission = missionRepository.findById(id).orElseThrow(() -> new RuntimeException("Mission not found"));
        return  missionDtoMapper.entityToDto(mission);
    }

}
