package com.azzedine.brikoli.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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


   @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<MissionRequestDto> createMission(
        @RequestPart("mission") MissionRequestDto dto,
        @RequestPart(value = "image",required = false) MultipartFile image
) {
    MissionRequestDto creation = missionService.createMission(dto, image);
    return ResponseEntity.ok(creation);
}


    @GetMapping("/user")
    public ResponseEntity<List<MissionRequestDto>> showAll(Authentication authentication){
        String email = authentication.getName();
        List<MissionRequestDto> missions = missionService.showUserMissions(email);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionRequestDto>> showMissions(){
        List<MissionRequestDto> missions = missionService.showAll();
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
    @GetMapping("/{id}")
    public ResponseEntity<MissionRequestDto> missionDetails(@PathVariable Long id){
        return ResponseEntity.ok(missionService.missionDetails(id));
    }
}
