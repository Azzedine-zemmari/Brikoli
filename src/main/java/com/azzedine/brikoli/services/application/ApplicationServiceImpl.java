package com.azzedine.brikoli.services.application;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.azzedine.brikoli.entity.Mission;
import com.azzedine.brikoli.dto.ApplicationRequestDto;
import com.azzedine.brikoli.entity.Application;
import com.azzedine.brikoli.entity.ProfessionalProfile;
import com.azzedine.brikoli.entity.User;
import com.azzedine.brikoli.enums.StatusApplication;
import com.azzedine.brikoli.mapper.ApplicationMapper;
import com.azzedine.brikoli.repository.ApplicationRepository;
import com.azzedine.brikoli.repository.MissionRepository;
import com.azzedine.brikoli.repository.ProfessionalRepository;
import com.azzedine.brikoli.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements applicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final ProfessionalRepository professionalRepository;

    @Override
    public void apply(ApplicationRequestDto dto) {

        Mission mission = missionRepository.findById(dto.missionId())
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        ProfessionalProfile professional = professionalRepository.findByUserId(getAuthenticatedUserId())
                .orElseThrow(() -> new RuntimeException("Professional not found"));

        Application application = new Application();
        application.setMission(mission);
        application.setMessage(dto.message());
        application.setProposedPrice(dto.proposedPrice());
        application.setStatusApplication(StatusApplication.PENDING);
        application.setAppliedAt(LocalDateTime.now());
        application.setProfessional(professional);

        applicationRepository.save(application);
    }

    private Long getAuthenticatedUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName(); // username = email

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getId();
    }
}
