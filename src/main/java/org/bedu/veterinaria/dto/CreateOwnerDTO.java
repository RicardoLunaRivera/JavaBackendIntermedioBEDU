package org.bedu.veterinaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateOwnerDTO {

    @Schema(description = "Nombre del dueño.", example = "John")
    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    private String name;

    @Schema(description = "Apellido Paterno del dueño.", example = "Smith")
    @NotEmpty(message = "El apellido del cliente no puede estar vacío")
    private String lastname;

    @Schema(description = "Domicilio del dueño de la mascota.", example = "123 Main St, City A")
    @NotEmpty(message = "Debe de ingresar un domicilo")
    private String address;

    @Schema(description = "Telefono de contacto del dueño de la mascota.", example = "5551234567")
    @NotEmpty(message = "Debe de ingresar un telefono")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @Schema(description = "Email de contacto del dueño de la mascota.", example = "john.smith@example.com")
    @NotNull
    @Email
    private String email;
}
