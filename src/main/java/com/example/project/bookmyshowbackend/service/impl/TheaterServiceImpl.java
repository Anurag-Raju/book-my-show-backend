package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.Model.TheaterSeatsEntity;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.Repository.TheaterSeatsRepository;
import com.example.project.bookmyshowbackend.converter.TheaterConverter;
import com.example.project.bookmyshowbackend.dto.TheaterDto;
import com.example.project.bookmyshowbackend.enums.SeatType;
import com.example.project.bookmyshowbackend.enums.TheaterType;
import com.example.project.bookmyshowbackend.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;
   @Override
    public TheaterDto addTheater(TheaterDto theaterDto) {
       TheaterEntity theaterEntity= TheaterConverter.convertDtoToEntity(theaterDto);

       List<TheaterSeatsEntity> seats=createTheaterSeats();
       theaterEntity.setSeats(seats);

       theaterEntity.setSeats(null);
       theaterEntity.setShows(null);

       for(TheaterSeatsEntity theaterSeatsEntity:seats){
           theaterSeatsEntity.setTheatre(theaterEntity);
       }
       theaterEntity.setType(TheaterType.SINGLE);
       log.info("The theater entity"+theaterEntity);

       theaterEntity=theaterRepository.save(theaterEntity);
        return theaterDto;
    }
    List<TheaterSeatsEntity> createTheaterSeats(){
        List<TheaterSeatsEntity> seats=new ArrayList<>();
        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",100,SeatType.PREMIUM));

        theaterSeatsRepository.saveAll(seats);
        return seats;
    }

    TheaterSeatsEntity getTheaterSeat(String seatName, int rate, SeatType seatType){
       return TheaterSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }
    @Override
    public TheaterDto getTheater(int id) {
        TheaterEntity theaterEntity= theaterRepository.findById(id).get();
        TheaterDto theaterDto= TheaterConverter.convertEntityToDto(theaterEntity);
        return theaterDto;
    }
}
