package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.UserDto;

public interface UserService {
    void addUser(UserDto userDto);

    UserDto getUser(int id);
}
