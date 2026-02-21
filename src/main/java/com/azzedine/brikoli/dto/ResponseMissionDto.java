package com.azzedine.brikoli.dto;

import com.azzedine.brikoli.enums.Urgency;

public record ResponseMissionDto(Long id , String title , String description , Double budgetMin , Double  budgetMax , String location , Urgency urgency , String imageName ,  String category , String firstName,String lastName,int missionNumber) {}
