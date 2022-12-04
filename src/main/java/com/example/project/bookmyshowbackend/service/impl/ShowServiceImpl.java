package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.*;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.ShowSeatsRepository;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.converter.ShowConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.ShowEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;
import com.example.project.bookmyshowbackend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;
    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        //we have partial show entity object
        ShowEntity showEntity= ShowConverter.convertDtoToEntity(showEntryDto);

        MovieEntity movieEntity=movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheaterEntity theaterEntity=theaterRepository.findById(showEntryDto.getTheaterDto().getId()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);

        generateShowEntitySeats(theaterEntity.getSeats(),showEntity);
        showEntity=showRepository.save(showEntity);
        ShowResponseDto showResponseDto=ShowConverter.convertEntityToDto(showEntity,showEntryDto);
        return showResponseDto;
    }
    public void generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList,ShowEntity showEntity){
        List<ShowSeatsEntity> showSeatsEntityList=new ArrayList<>();

        for(TheaterSeatsEntity tse:theaterSeatsEntityList){
            ShowSeatsEntity showSeatsEntity=ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }
        //We need to set the show Entity for each of the ShowSeat
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);
        showSeatsRepository.saveAll(showSeatsEntityList);
    }
//
//    @Override
//    public ShowResponseDto getShow(int id) {
//        ShowEntity showEntity=showRepository.findById(id).get();
//        ShowResponseDto showResponseDto=ShowConverter.convertEntityToDto(showEntity,sh);
//        return showResponseDto;
//    }
}
