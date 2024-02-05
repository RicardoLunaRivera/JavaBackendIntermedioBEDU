package org.bedu.veterinaria.dto.owner_dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateOwnerDTO {

    @Schema(description = "Identificador para ingresar el nombre del cliente", example = "Ana")
    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @NotNull
    private String name;

    @Schema(description = "Identificador para ingresar el apellido del cliente", example = "Mena")
    @NotEmpty(message = "El apellido del cliente no puede estar vacío")
    @NotNull
    private String lastname;

    @Schema(description = "Identificador para ingresar el domicilio del cliente",example = "Calle rio 123")
    @NotEmpty(message = "Debe de ingresar un domicilo")
    @NotNull
    private String address;

    @Schema(description = "Identificador para ingresar el telefono del cliente", example = "123-123-1234")
    @NotEmpty(message = "Debe de ingresar un telefono")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    @NotNull
    private String phone;

    @Schema(description = "Identificador para ingresar el email del cliente",example = "ana@mail.com")
    @NotEmpty(message = "Debe proporcionar un email")
    @NotNull
    @Email
    private String email;

    public void setBirthDate(String date) {
        //metodo creado para pruebas
    }
}