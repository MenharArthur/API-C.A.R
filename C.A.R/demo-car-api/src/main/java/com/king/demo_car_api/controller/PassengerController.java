package com.king.demo_car_api.controller;

import com.king.demo_car_api.DTO.PassengerDTO;
import com.king.demo_car_api.entitys.Passenger;
import com.king.demo_car_api.mapper.MapperDTOPassenger;
import com.king.demo_car_api.repository.PassengerRepository;
import com.king.demo_car_api.service.PassengerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path="/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerController {

    @Autowired
    PassengerService passengerService ;

    /* Listar todos os passaigeiros  */
    @GetMapping()
    public ResponseEntity<List<PassengerDTO>> listPassengers(){

        List<Passenger> passengers =  passengerService.listPassengers();

        return ResponseEntity.ok(MapperDTOPassenger.mapperList(passengers));
    }

    /* Encontrar passageiro pelo id  */
    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> findPassenger(@PathVariable("id") Long id) {

        Passenger passenger = passengerService.findPassenger(id);

        return ResponseEntity.ok(MapperDTOPassenger.mapper(passenger));
    }

    /* Criar novos perfis de passageiro  */
    @PostMapping
    public ResponseEntity<PassengerDTO> createPassenger(@Valid @RequestBody PassengerDTO passengerDTO){

        Passenger passenger = passengerService.createPassenger(MapperDTOPassenger.map(passengerDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(MapperDTOPassenger.mapper(passenger));
    }

    /* Atualizar o perfil do passageiro  */
    @PutMapping("/{id}")
    public ResponseEntity<Void> fullUpdatePassenger(@PathVariable("id") Long id, @Valid @RequestBody PassengerDTO passengerDTO) {

        Passenger passenger =  passengerService.fullUpdatePassenger(id, MapperDTOPassenger.map(passengerDTO));

        return ResponseEntity.noContent().build();
    }

    /* Atualização parcial do perfil do passageiro  */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> incrementalUpdatePassenger(@PathVariable("id") Long id, @Valid @RequestBody PassengerDTO passengerDTO){

        Passenger passenger = passengerService.incrementalUpdatePassenger(id, MapperDTOPassenger.map(passengerDTO));

        return ResponseEntity.noContent().build();
    }

    /* Deletar perfil do passageiro  */
    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        passengerService.deletePassenger(id);
    }
}
