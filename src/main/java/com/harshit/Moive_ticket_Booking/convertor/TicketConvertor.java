package com.harshit.Moive_ticket_Booking.convertor;

import com.harshit.Moive_ticket_Booking.entities.Show;
import com.harshit.Moive_ticket_Booking.entities.Ticket;
import com.harshit.Moive_ticket_Booking.response.TicketResponse;

public class TicketConvertor {

    public static TicketResponse returnTicket(Show show, Ticket ticket) {
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
