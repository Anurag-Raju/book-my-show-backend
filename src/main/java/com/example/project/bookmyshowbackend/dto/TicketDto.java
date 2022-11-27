package com.example.project.bookmyshowbackend.dto;

import com.example.project.bookmyshowbackend.Model.UserEntity;
import lombok.*;

@Builder
@Data
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    UserDto userDto;

    ShowDto showDto;
}
