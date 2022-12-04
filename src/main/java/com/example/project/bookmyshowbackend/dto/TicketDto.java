package com.example.project.bookmyshowbackend.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Data
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;
    @NotNull
    UserDto userDto;//mandatory for me to fill this userDto value

    ShowDto showDto;
}
