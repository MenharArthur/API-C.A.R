package com.king.demo_car_api.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DriverDTO {

    @NotNull
    private Long id;
    @NotBlank(message = "Digite o nome para o cadastro")
    private String name;
    @NotNull(message = "Digite a data de aniversário")
    private LocalDate birthDate;

}
