package com.example.project.bookmyshowbackend.dto;

import com.example.project.bookmyshowbackend.enums.SeatType;
import lombok.*;

import java.util.Set;
@Data
@Builder
public class BookTicketRequestDto {

    Set<String> requestedSeats;

    int id;

    int showId;

    SeatType seatType;
}
