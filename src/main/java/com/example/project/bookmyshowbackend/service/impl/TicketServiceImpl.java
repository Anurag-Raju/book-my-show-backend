package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.Model.ShowSeatsEntity;
import com.example.project.bookmyshowbackend.Model.TicketEntity;
import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.TicketRepository;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.converter.TicketConverter;
import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;
import com.example.project.bookmyshowbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public TicketDto getTicket(int id) {
        TicketEntity ticketEntity=ticketRepository.findById(id).get();
        TicketDto ticketDto= TicketConverter.convertEntityToDto(ticketEntity);
        return ticketDto;
    }

    @Override
    public TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        ShowEntity showEntity=showRepository.findById(bookTicketRequestDto.getShowId()).get();

        UserEntity userEntity= userRepository.findById(bookTicketRequestDto.getId()).get();

        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList=showEntity.getSeats();
        //Option1
        List<ShowSeatsEntity> bookedSeats=showSeatsEntityList
                .stream()
                .filter(seat-> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
                        requestedSeats.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());
        //Option2
//        List<ShowSeatsEntity> bookedSeats1=new ArrayList<>();
//        for(ShowSeatsEntity seat:showSeatsEntityList){
//            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&
//                    requestedSeats.contains(seat.getSeatNumber())){
//                bookedSeats1.add(seat);
//            }
//        }

        if(bookedSeats.size()!=requestedSeats.size()){
            throw new Error("All Seats not available");
        }
        //Step2
        TicketEntity ticketEntity=TicketEntity.builder()
                .user(userEntity)
                .show(showEntity)
                .seats(bookedSeats)
                .build();

        //Step3
        double amount=0;

        for (ShowSeatsEntity showSeatsEntity:bookedSeats){
            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount=amount+showSeatsEntity.getRate();

        }
        ticketEntity.setAlloted_seats(String.valueOf(bookedSeats));
        ticketEntity.setAmount(amount);
        //connect in the show and the user
        showEntity.getTickets().add(ticketEntity);
        //add the tickets in the tickets list of the user entity
        userEntity.getTicketEntities().add(ticketEntity);

        ticketEntity=ticketRepository.save(ticketEntity);
        return TicketConverter.convertEntityToDto(ticketEntity);
    }
}
