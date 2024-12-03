package com.harshit.Moive_ticket_Booking.repository;

import com.harshit.Moive_ticket_Booking.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
