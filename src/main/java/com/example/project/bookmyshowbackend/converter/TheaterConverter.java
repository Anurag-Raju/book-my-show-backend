package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.dto.TheaterDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterDto theaterDto){
        return TheaterEntity.builder().id(theaterDto.getId()).name(theaterDto.getName())
                .address(theaterDto.getAddress()).city(theaterDto.getCity()).build();
    }

    public static TheaterDto convertEntityToDto(TheaterEntity theaterEntity){
        return TheaterDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .address(theaterEntity.getAddress()).city(theaterEntity.getCity()).build();
    }
}
