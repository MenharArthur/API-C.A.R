package com.king.demo_car_api.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Passenger {

    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "digite o nome para cadastro")
    String name;
}
