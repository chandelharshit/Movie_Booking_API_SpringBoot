package com.harshit.Moive_ticket_Booking.requestDTO;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequest {
    private Integer showId;
    private Integer userId;
    private List<String> requestSeats;
}
