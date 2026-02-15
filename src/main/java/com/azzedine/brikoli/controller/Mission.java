package com.azzedine.brikoli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.services.mission.MissionService;

import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/mission")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class Mission {
    private MissionService missionService;


    @PostMapping("/create")
    public ResponseEntity<MissionRequestDto> createMission(@RequestBody MissionRequestDto dto){
        MissionRequestDto creation = missionService.createMission(dto);
        return ResponseEntity.ok(creation);
    }

    @GetMapping("/user/mission")
    public ResponseEntity<List<MissionRequestDto>> showAll(Authentication authentication){
        String email = authentication.getName();
        List<MissionRequestDto> missions = missionService.showUserMissions(email);
        return ResponseEntity.ok(missions);
    }

}
