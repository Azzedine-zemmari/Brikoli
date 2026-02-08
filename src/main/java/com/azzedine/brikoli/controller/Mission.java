package com.azzedine.brikoli.controller;

import org.springframework.http.ResponseEntity;
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
public class Mission {
    private MissionService missionService;


    @PostMapping("/create")
    public ResponseEntity<MissionRequestDto> createMission(@RequestBody MissionRequestDto dto){
        MissionRequestDto creation = missionService.createMission(dto);
        return ResponseEntity.ok(creation);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionRequestDto>> showAll(){
        List<MissionRequestDto> missions = missionService.showAll();
        return ResponseEntity.ok(missions);
    }

}
