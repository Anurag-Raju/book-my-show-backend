package com.example.project.bookmyshowbackend.controller;

import com.example.project.bookmyshowbackend.dto.TheaterDto;
import com.example.project.bookmyshowbackend.service.impl.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {
    @Autowired
    TheaterServiceImpl theaterService;

    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody() TheaterDto theaterDto){
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
