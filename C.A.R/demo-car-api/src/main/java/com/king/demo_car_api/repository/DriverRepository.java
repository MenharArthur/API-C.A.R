package com.king.demo_car_api.repository;

import com.king.demo_car_api.entitys.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
