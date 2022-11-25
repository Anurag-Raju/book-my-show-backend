package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.*;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.converter.ShowConverter;
import com.example.project.bookmyshowbackend.dto.ShowDto;
import com.example.project.bookmyshowbackend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Override
    public ShowDto addShow(ShowDto showDto) {
        //we have partial show entity object
        ShowEntity showEntity= ShowConverter.convertDtoToEntity(showDto);

        MovieEntity movieEntity=movieRepository.findById(showDto.getMovieDto().getId()).get();

        TheaterEntity theaterEntity=theaterRepository.findById(showDto.getTheaterDto().getId()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);

        generateShowEntitySeats(theaterEntity.getSeats());
//        showEntity=showRepository.save(showEntity);
//        return showDto;
    }
    public void generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList){
        List<ShowSeatsEntity> showSeatsEntityList=new ArrayList<>();

        for(TheaterSeatsEntity tse:theaterSeatsEntityList){
            
        }
    }

    @Override
    public ShowDto getShow(int id) {
        ShowEntity showEntity=showRepository.findById(id).get();
        ShowDto showDto=ShowConverter.convertEntityToDto(showEntity);
        return showDto;
    }
}
