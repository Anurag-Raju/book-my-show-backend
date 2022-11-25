package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.ShowDto;

public interface ShowService {

    ShowDto addShow(ShowDto showDto);

    ShowDto getShow(int id);
}
