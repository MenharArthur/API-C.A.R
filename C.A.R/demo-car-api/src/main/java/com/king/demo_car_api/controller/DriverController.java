package com.king.demo_car_api.controller;

import com.king.demo_car_api.DTO.DriverDTO;
import com.king.demo_car_api.entitys.Driver;
import com.king.demo_car_api.mapper.MapperDTODriver;
import com.king.demo_car_api.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    MapperDTODriver mapper;

    /* Inserir novos  motoristas  */
    @PostMapping("/drivers")
    public ResponseEntity<DriverDTO> createDriver(@Valid @RequestBody DriverDTO driverDTO){

        Driver driver = driverService.createDriver(MapperDTODriver.map(driverDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(MapperDTODriver.mape(driver));
    }

    /* Encontrar  motoristas  */
    @GetMapping("/drivers/{id}")
    public ResponseEntity<DriverDTO> findDriver(@PathVariable("id") Long id){

        Driver driver = driverService.findDriver(id);

        return ResponseEntity.ok(MapperDTODriver.mape(driver));
    }

    /* Atualizar   motoristas  */
    @PutMapping("/drivers/{id}")
    public ResponseEntity<Void> fullUpdateDriver(@PathVariable("id") Long id,@Valid @RequestBody DriverDTO driverDTO){

        Driver driver = driverService.fullUpdateDriver(id, MapperDTODriver.map(driverDTO));

        return ResponseEntity.noContent().build();
    }

    /* Deletar o  perfil do motorista desejado  */
    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable("id") Long id){
        driverService.deleteDriver(id);
    }

    /* Listar todos os  motoristas  */
    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDTO>> listDrivers(){

        List<Driver> drivers =  driverService.listDrivers();

        return ResponseEntity.ok(MapperDTODriver.mapperList(drivers));
    }
}
