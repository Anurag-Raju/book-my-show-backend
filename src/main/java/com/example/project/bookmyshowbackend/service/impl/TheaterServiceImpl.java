package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.converter.TheaterConverter;
import com.example.project.bookmyshowbackend.dto.TheaterDto;
import com.example.project.bookmyshowbackend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;

public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
   @Override
    public TheaterDto addTheater(TheaterDto theaterDto) {
       TheaterEntity theaterEntity= TheaterConverter.convertDtoToEntity(theaterDto);
               theaterRepository.save(theaterEntity);
        return theaterDto;
    }

    @Override
    public TheaterDto getTheater(int id) {
        TheaterEntity theaterEntity= theaterRepository.findById(id).get();
        TheaterDto theaterDto= TheaterConverter.convertEntityToDto(theaterEntity);
        return theaterDto;
    }
}
