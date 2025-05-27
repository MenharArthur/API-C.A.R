package com.king.demo_car_api.DTO;

import com.king.demo_car_api.entitys.Passenger;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TravelRequestInput {

    Long passengerId;
    @NotBlank(message = "Digite o endereço de origem")
    String origin;
    @NotBlank(message = "Digite o endereço de destino")
    String destination;
}
