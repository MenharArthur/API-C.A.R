package com.king.demo_car_api.repository;

import com.king.demo_car_api.entitys.TravelRequest;
import com.king.demo_car_api.entitys.TravelRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
    List<TravelRequest> findByStatus(TravelRequestStatus status);
}
