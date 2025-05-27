package com.king.demo_car_api.mapper;

import com.king.demo_car_api.DTO.PassengerDTO;
import com.king.demo_car_api.entitys.Passenger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class MapperDTOPassenger {

    public static Passenger map(PassengerDTO passengerDTO){

        Passenger passenger = new Passenger();
        passenger.setId(passengerDTO.getId());
        passenger.setName(passengerDTO.getName());

        return passenger;

    }

    public static PassengerDTO mapper(Passenger passenger){

        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(passenger.getId());
        passengerDTO.setName(passengerDTO.getName());

        return passengerDTO;
    }

    public static List<PassengerDTO> mapperList(List<Passenger> passengers){

        return passengers.stream().map(passenger -> mapper(passenger)).collect(Collectors.toList());
    }


}
