package com.harshit.Moive_ticket_Booking.service;

import com.harshit.Moive_ticket_Booking.convertor.MovieConvertor;
import com.harshit.Moive_ticket_Booking.entities.Movie;
import com.harshit.Moive_ticket_Booking.exceptions.MovieAlreadyExist;
import com.harshit.Moive_ticket_Booking.repository.MovieRepository;
import com.harshit.Moive_ticket_Booking.repository.ShowRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService  {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;

    public String addMovie(MovieRequest movieRequest){
        Movie movieByName=movieRepository.findByMovieName(movieRequest.getMovieName());

        if(movieByName!=null && movieByName.getLanguage().equals(movieRequest.getLanguage())){
                throw new MovieAlreadyExist();
        }

        Movie movie= MovieConvertor.movieDtoToMovie(movieRequest);
        movieRepository.save(movie);
        return "Movie Saved SuccessFully";
    }


}
