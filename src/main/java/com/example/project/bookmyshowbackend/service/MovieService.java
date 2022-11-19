package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.MovieDto;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);

    MovieDto getMovie(int id);
}
