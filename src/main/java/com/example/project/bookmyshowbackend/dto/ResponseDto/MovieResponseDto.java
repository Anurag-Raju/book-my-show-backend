package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.dto.ShowDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Builder
@Data
public class MovieResponseDto {
    int id;

    String name;

    LocalDate releaseDate;

    List<ShowDto> showDtoList;
}
