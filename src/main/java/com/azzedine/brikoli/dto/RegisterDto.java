package com.azzedine.brikoli.dto;
import com.azzedine.brikoli.enums.Role;

public record RegisterDto(String firstName , String lastName , String email , String phone , String password , Role role ) {}
