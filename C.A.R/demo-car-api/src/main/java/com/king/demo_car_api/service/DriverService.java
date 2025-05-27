package com.king.demo_car_api.service;

import com.king.demo_car_api.entitys.Driver;
import com.king.demo_car_api.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;


    public Driver createDriver(Driver driver){

        return driverRepository.save(driver);
    }


    public Driver findDriver(Long id){

        return driverRepository.findById(id).get();
    }


    public Driver fullUpdateDriver(Long id, Driver driver){

        Driver foundDriver = findDriver(id);
        foundDriver.setBirthDate(driver.getBirthDate());
        foundDriver.setName(driver.getName());
        return driverRepository.save(foundDriver);
    }

    public void deleteDriver(Long id){

        driverRepository.delete(findDriver(id));
    }

    public List<Driver> listDrivers(){

        return driverRepository.findAll();
    }

}
