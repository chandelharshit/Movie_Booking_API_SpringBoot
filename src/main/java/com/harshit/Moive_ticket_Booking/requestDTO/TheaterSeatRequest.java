package com.harshit.Moive_ticket_Booking.requestDTO;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String address;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
}
