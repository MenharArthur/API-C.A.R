package com.king.demo_car_api.repository;

import com.king.demo_car_api.entitys.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
