package com.king.demo_car_api.service;

import com.king.demo_car_api.entitys.Passenger;
import com.king.demo_car_api.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository ;

    public List<Passenger> listPassengers(){

        return passengerRepository.findAll();
    }

    public Passenger findPassenger( Long id) {
        return passengerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Passenger createPassenger( Passenger passenger){

        return passengerRepository.save(passenger);
    }

    public Passenger fullUpdatePassenger( Long id, Passenger passenger) {

        Passenger p = findPassenger(id);
        p.setName(passenger.getName());
        return passengerRepository.save(p);
    }

    public Passenger incrementalUpdatePassenger( Long id,  Passenger passenger){

        Passenger foundPassenger = findPassenger(id);
        foundPassenger.setName(Optional.ofNullable(passenger.getName()).orElse(foundPassenger.getName()));
        return passengerRepository.save(foundPassenger);
    }

    public void deletePassenger(Long id) {
        passengerRepository.delete(findPassenger(id));
    }


}
