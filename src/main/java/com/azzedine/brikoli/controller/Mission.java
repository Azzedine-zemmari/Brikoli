package com.azzedine.brikoli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.enums.MissionStatus;
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

    @GetMapping("/user")
    public ResponseEntity<List<MissionRequestDto>> showAll(Authentication authentication){
        String email = authentication.getName();
        List<MissionRequestDto> missions = missionService.showUserMissions(email);
        return ResponseEntity.ok(missions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierMission(@PathVariable Long id , @RequestBody MissionRequestDto dto){
        missionService.modifierMission(id,dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/posted")
    public ResponseEntity<Long> countPostedMissions(){
        return ResponseEntity.ok(missionService.countMission(MissionStatus.POSTED));
    }
    @GetMapping("/en_cours")
    public ResponseEntity<Long> countInProgressMissions(){
        return ResponseEntity.ok(missionService.countMission(MissionStatus.IN_PROGRESS));
    }
    @GetMapping("/completed")
    public ResponseEntity<Long> countCompletedMissions(){
        return ResponseEntity.ok(missionService.countMission(MissionStatus.COMPLETED));
    }

}
