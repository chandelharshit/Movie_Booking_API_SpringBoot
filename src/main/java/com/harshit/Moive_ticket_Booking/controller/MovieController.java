package com.harshit.Moive_ticket_Booking.controller;


import com.harshit.Moive_ticket_Booking.requestDTO.MovieRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @PostMapping("/addNew")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest){
        return null;
    }
}
