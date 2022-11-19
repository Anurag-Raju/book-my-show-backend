package com.example.project.bookmyshowbackend.dto;

import lombok.*;

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

    ShowDto showDto;
}
