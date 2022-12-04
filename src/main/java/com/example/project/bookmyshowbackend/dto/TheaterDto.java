package com.example.project.bookmyshowbackend.dto;

import com.example.project.bookmyshowbackend.enums.TheaterType;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDto {

    int id;

    String name;

    String address;

    String city;

    TheaterType type;

    List<ShowDto> showDtoList;
}
