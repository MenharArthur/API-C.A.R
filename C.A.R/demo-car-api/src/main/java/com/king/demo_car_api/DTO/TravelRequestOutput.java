package com.king.demo_car_api.DTO;

import com.king.demo_car_api.entitys.Passenger;
import com.king.demo_car_api.entitys.TravelRequestStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelRequestOutput {

    Long id;
    String Origin;
    String destination;
    TravelRequestStatus status;
    LocalDateTime creationDate;

}
