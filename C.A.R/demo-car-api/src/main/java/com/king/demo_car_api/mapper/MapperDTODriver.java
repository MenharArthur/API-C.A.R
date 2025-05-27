package com.king.demo_car_api.mapper;

import com.king.demo_car_api.DTO.DriverDTO;
import com.king.demo_car_api.entitys.Driver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperDTODriver {

    /* sua função é transformar um objeto DTO em um objeto original */
    public static Driver map(DriverDTO driverDTO){

        Driver driver = new Driver();
        driver.setId(driverDTO.getId());
        driver.setName(driverDTO.getName());
        driver.setBirthDate(driverDTO.getBirthDate());

        return driver;

    }

    public static DriverDTO mape(Driver driver){

        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driver.getId());
        driverDTO.setName(driver.getName());
        driverDTO.setBirthDate(driver.getBirthDate());

        return driverDTO;

    }

    public static List<DriverDTO> mapperList(List<Driver> drivers){
        return drivers.stream().map(driver -> mape(driver)).collect(Collectors.toList());
    }

}
