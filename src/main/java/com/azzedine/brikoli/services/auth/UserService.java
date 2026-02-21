package com.azzedine.brikoli.services.auth;

import com.azzedine.brikoli.dto.RegisterDto;
import com.azzedine.brikoli.dto.RequestLoginDto;
import com.azzedine.brikoli.dto.ResponseLoginDto;
import com.azzedine.brikoli.dto.ResponseUserDto;

public interface UserService {
    void userRegister(RegisterDto dto);
    ResponseLoginDto login(RequestLoginDto dto);
    ResponseUserDto userAuthenticated();
}
