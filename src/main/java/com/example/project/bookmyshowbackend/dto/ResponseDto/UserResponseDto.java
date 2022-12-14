package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class UserResponseDto {

    int id;

    String name;

    String mobNo;
    //optional
    List<TicketDto> tickets;
}
