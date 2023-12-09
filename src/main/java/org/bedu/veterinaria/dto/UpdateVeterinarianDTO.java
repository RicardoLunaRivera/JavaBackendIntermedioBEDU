package org.bedu.veterinaria.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateVeterinarianDTO {
    @Id
    private Long idVeterinarian;

    @NotEmpty(message = "Missing name")
    private String name;

    @NotEmpty(message = "Missing Lastname")
     private String lastname;

    @NotEmpty(message = "Missing Schedule")
    private String schedule;

    @NotEmpty(message = "Debe de ingresar un telefono")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    
    @NotEmpty(message = "Missing Specialty")
     private String specialty;

}

