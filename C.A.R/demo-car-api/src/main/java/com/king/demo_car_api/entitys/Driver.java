package com.king.demo_car_api.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "Digite o nome para o cadastro")
    String name;
    @NotNull(message = "Digite a data de aniversário")
    LocalDate birthDate;
}
