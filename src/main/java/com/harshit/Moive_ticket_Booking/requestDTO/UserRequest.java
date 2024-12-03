package com.harshit.Moive_ticket_Booking.requestDTO;

import com.harshit.Moive_ticket_Booking.enums.Gender;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private String roles;
}
