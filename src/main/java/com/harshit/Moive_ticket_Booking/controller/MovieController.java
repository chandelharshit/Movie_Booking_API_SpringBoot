package com.harshit.Moive_ticket_Booking.controller;


import com.harshit.Moive_ticket_Booking.repository.MovieRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.MovieRequest;
import com.harshit.Moive_ticket_Booking.requestDTO.ShowSeatRequest;
import com.harshit.Moive_ticket_Booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest){
        try{
            String res= movieService.addMovie(movieRequest);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
