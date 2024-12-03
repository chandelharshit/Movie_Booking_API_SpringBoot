package com.harshit.Moive_ticket_Booking.controller;


import com.harshit.Moive_ticket_Booking.repository.ShowRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.ShowRequest;
import com.harshit.Moive_ticket_Booking.requestDTO.ShowSeatRequest;
import com.harshit.Moive_ticket_Booking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;
    @PostMapping("/addNew")
    public ResponseEntity<String> addShows(@RequestBody ShowRequest showRequest){

        try{
            String res=showService.addShows(showRequest);
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateShowSeats(@RequestBody ShowSeatRequest showSeatRequest){
        try{
            String res=showService.associateShowSeats(showSeatRequest);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
