package com.harshit.Moive_ticket_Booking.convertor;

import com.harshit.Moive_ticket_Booking.entities.Show;
import com.harshit.Moive_ticket_Booking.requestDTO.ShowRequest;

public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date(showRequest.getShowDate())
                .build();

        return show;
    }
}
