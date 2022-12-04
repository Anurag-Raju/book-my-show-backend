package com.example.project.bookmyshowbackend.dto.EntryRequest;

import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import com.example.project.bookmyshowbackend.dto.TheaterDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Builder
@Data
public class ShowEntryDto {
    @NotNull
    LocalDate showDate;
    @NotNull
    LocalTime showTime;
    @NotNull
    MovieResponseDto movieResponseDto;
    @NotNull
    TheaterDto theaterDto;
}
