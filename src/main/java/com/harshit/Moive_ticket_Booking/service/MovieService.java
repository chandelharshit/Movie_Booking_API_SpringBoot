package com.harshit.Moive_ticket_Booking.service;

import com.harshit.Moive_ticket_Booking.entities.Movie;
import com.harshit.Moive_ticket_Booking.exceptions.MovieAlreadyExist;
import com.harshit.Moive_ticket_Booking.repository.MovieRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService  {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest){
        Movie moviebyName=movieRepository.findByMovieName(movieRequest.getMovieName());

        if(moviebyName!=null && moviebyName.getLanguage().equals(movieRequest.getLanguage())){
                throw new MovieAlreadyExist();
        }

    }
}
