package com.king.demo_car_api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PassengerDTO {


    @NotNull
    private Long id;
    @NotBlank(message = "digite o nome para cadastro")
    private String name;

}
