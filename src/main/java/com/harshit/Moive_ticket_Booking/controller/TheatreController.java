package com.harshit.Moive_ticket_Booking.controller;


import com.harshit.Moive_ticket_Booking.repository.TheaterRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.TheaterRequest;
import com.harshit.Moive_ticket_Booking.requestDTO.TheaterSeatRequest;
import com.harshit.Moive_ticket_Booking.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addNewTheatre(@RequestBody TheaterRequest request){
        try{
            String res=theaterService.addTheatre(request);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addTheatreSeat")
    public ResponseEntity<String> addTheatreSeat(@RequestBody TheaterSeatRequest requestDto){
        try{
            String res=theaterService.addTheaterSeat(requestDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
