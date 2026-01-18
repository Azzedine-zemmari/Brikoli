package com.azzedine.brikoli.services.auth;

import com.azzedine.brikoli.dto.RegisterDto;

public interface UserService {
    void userRegister(RegisterDto dto);
}
