package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.dto.EntryRequest.UserEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;


@UtilityClass//whose objects cannot be created/all the methods are static/only the methods can be called
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();
        //second method for creating object by using new keyword
    }

    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName())
                .mobNo(userEntity.getMobile()).build();
    }
}
