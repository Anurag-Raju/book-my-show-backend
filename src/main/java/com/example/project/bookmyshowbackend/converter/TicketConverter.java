package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.TicketEntity;
import com.example.project.bookmyshowbackend.dto.TicketDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketDto convertEntityToDto(TicketEntity ticketEntity){
          return TicketDto.builder().id(ticketEntity.getId())
                  .amount(ticketEntity.getAmount())
                  .alloted_seats(ticketEntity.getAlloted_seats())
                  .build();
    }

    public static TicketEntity convertDtoToEntity(TicketDto ticketDto){
          return TicketEntity.builder().id(ticketDto.getId())
                  .alloted_seats(ticketDto.getAlloted_seats())
                  .amount(ticketDto.getAmount())
                  .build();
    }
}
