package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.dto.TheaterDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class ShowResponseDto {
    int id;

    LocalDate showDate;

    LocalTime showTime;
    @NonNull
    MovieResponseDto movieResponseDto;
    @NotNull
    TheaterDto theaterDto;
}
