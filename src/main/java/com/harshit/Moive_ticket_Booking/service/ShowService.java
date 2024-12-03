package com.harshit.Moive_ticket_Booking.service;

import com.harshit.Moive_ticket_Booking.convertor.ShowConvertor;
import com.harshit.Moive_ticket_Booking.entities.*;
import com.harshit.Moive_ticket_Booking.enums.SeatType;
import com.harshit.Moive_ticket_Booking.exceptions.MovieDoesNotExists;
import com.harshit.Moive_ticket_Booking.exceptions.ShowDoesNotExists;
import com.harshit.Moive_ticket_Booking.exceptions.TheaterDoesNotExists;
import com.harshit.Moive_ticket_Booking.repository.MovieRepository;
import com.harshit.Moive_ticket_Booking.repository.ShowRepository;
import com.harshit.Moive_ticket_Booking.repository.TheaterRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.ShowRequest;
import com.harshit.Moive_ticket_Booking.requestDTO.ShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterRepository theaterRepository;

    public String addShows(ShowRequest showRequest){
        Show show= ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt=movieRepository.findById(showRequest.getMovieId());
        Optional<Theater> theaterOpt=theaterRepository.findById(showRequest.getTheaterId());
        if(movieOpt.isEmpty()) throw new MovieDoesNotExists();
        if(theaterOpt.isEmpty()) throw new TheaterDoesNotExists();

        Theater theater=theaterOpt.get();
        Movie movie=movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show=showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);


        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show Added Succesfully";
    }

    public String associateShowSeats(ShowSeatRequest showSeatRequest) {
        Optional<Show> showOpt= showRepository.findById(showSeatRequest.getShowId());
        if(showOpt.isEmpty()) throw new ShowDoesNotExists();

        Show show=showOpt.get();
        Theater theater=showOpt.get().getTheater();

        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();
        List<ShowSeat> showSeatList=show.getShowSeatList();

        for(TheaterSeat theaterSeat:theaterSeatList){
            ShowSeat showSeat=new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showSeatRequest.getPriceOfClassicSeat());
            }
            else showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());

            showSeatList.add(showSeat);
        }
        showRepository.save(show);

        return "Show seats have been associated successfully";
    }

}
