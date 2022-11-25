package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.dto.UserDto;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass//whose objects cannot be created/all the methods are static/only the methods can be called
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserDto userDto){
        return UserEntity.builder().name(userDto.getName()).mobile(userDto.getMobileNo()).build();
        //second method for creating object by using new keyword
    }

    public static UserDto convertEntityToDto(UserEntity userEntity){
        return UserDto.builder().id(userEntity.getId()).name(userEntity.getName())
                .mobileNo(userEntity.getMobile()).build();
    }
}
