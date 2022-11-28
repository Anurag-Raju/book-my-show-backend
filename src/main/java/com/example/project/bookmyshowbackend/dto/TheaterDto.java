package com.example.project.bookmyshowbackend.dto;

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

    List<ShowDto> showDtoList;
}
