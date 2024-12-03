package com.harshit.Moive_ticket_Booking.repository;

import com.harshit.Moive_ticket_Booking.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String movieName);
}
