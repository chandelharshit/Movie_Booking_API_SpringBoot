package com.harshit.Moive_ticket_Booking.service;

import com.harshit.Moive_ticket_Booking.convertor.TheaterConvertor;
import com.harshit.Moive_ticket_Booking.entities.Theater;
import com.harshit.Moive_ticket_Booking.entities.TheaterSeat;
import com.harshit.Moive_ticket_Booking.enums.SeatType;
import com.harshit.Moive_ticket_Booking.exceptions.TheaterDoesNotExists;
import com.harshit.Moive_ticket_Booking.exceptions.TheaterIsExist;
import com.harshit.Moive_ticket_Booking.repository.TheaterRepository;
import com.harshit.Moive_ticket_Booking.requestDTO.TheaterRequest;
import com.harshit.Moive_ticket_Booking.requestDTO.TheaterSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheatre(TheaterRequest theaterRequest) throws TheaterIsExist {
        if(theaterRepository.findByAddress(theaterRequest.getAddress())!=null){
            throw new TheaterIsExist();
        }
        Theater theater= TheaterConvertor.theaterDtoToTheater(theaterRequest);
        theaterRepository.save(theater);
        return "Theatre saved Successfully";
    }

    public String addTheaterSeat(TheaterSeatRequest requestDto) {
        if(theaterRepository.findByAddress(requestDto.getAddress())==null){
            throw new TheaterDoesNotExists();
        }

        Integer noOfSeatsInRow= requestDto.getNoOfSeatInRow();
        Integer noOfClassicSeats= requestDto.getNoOfClassicSeat();
        Integer noOfPremiumSeats= requestDto.getNoOfPremiumSeat();
        String address=requestDto.getAddress();

        Theater theater=theaterRepository.findByAddress(address);
        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for (int i = 1; i <= noOfClassicSeats; i++) {
            String seatNo = Integer.toString(counter) + ch;

            ch++;
            fill++;
            if (fill == noOfSeatsInRow) {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theaterSeat.setTheater(theater);
            theaterSeatList.add(theaterSeat);
        }

        for (int i = 1; i <= noOfPremiumSeats; i++) {
            String seatNo = Integer.toString(counter) + ch;

            ch++;
            fill++;
            if (fill == noOfSeatsInRow) {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setTheater(theater);
            theaterSeatList.add(theaterSeat);
        }

        theaterRepository.save(theater);

        return "Theater Seats have been added successfully";

    }
}
