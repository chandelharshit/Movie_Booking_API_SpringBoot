package com.harshit.Moive_ticket_Booking.requestDTO;

import com.harshit.Moive_ticket_Booking.enums.Genre;
import com.harshit.Moive_ticket_Booking.enums.Language;
import lombok.Data;

import java.sql.Date;

@Data
public class MovieRequest {
	private String movieName;
	private Integer duration;
	private Double rating;
	private Date releaseDate;
	private Genre genre;
	private Language language;
}
