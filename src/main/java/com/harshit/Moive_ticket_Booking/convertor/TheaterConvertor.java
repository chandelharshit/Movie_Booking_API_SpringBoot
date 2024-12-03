package com.harshit.Moive_ticket_Booking.convertor;


import com.harshit.Moive_ticket_Booking.entities.Theater;
import com.harshit.Moive_ticket_Booking.requestDTO.TheaterRequest;

public class TheaterConvertor {

    public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();
        return theater;
    }
}
