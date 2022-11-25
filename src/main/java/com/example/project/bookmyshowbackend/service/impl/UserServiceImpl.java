package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.converter.UserConverter;
import com.example.project.bookmyshowbackend.dto.UserDto;
import com.example.project.bookmyshowbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(UserDto userDto) {

        UserEntity userEntity= UserConverter.convertDtoToEntity(userDto);

        userRepository.save(userEntity);
        //id's are automatically generated by @GeneratedValues during save not required in convertDtoToEntity
    }

    @Override
    public UserDto getUser(int id) {
        UserEntity userEntity=userRepository.findById(id).get();//if null it will throw an error or else return value
        // /orElse()
        UserDto userDto=UserConverter.convertEntityToDto(userEntity);
        return userDto;
    }
}
