package com.harshit.Moive_ticket_Booking.repository;

import com.harshit.Moive_ticket_Booking.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}
