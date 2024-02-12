package org.bedu.veterinaria.dto.owner_dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OwnerDTO {
    @Schema(description = "Identificador del cliente", example = "10")
    private Long idOwner;

    @Schema(description = "Identificador para ingresar el nombre del cliente", example = "Ana")
    private String name;

    @Schema(description = "Identificador para ingresar el apellido del cliente", example = "Mena")
    private String lastname;

    @Schema(description = "Identificador para ingresar el domicilio del cliente",example = "Calle rio 123")
    private String address;

    @Schema(description = "Identificador para ingresar el telefono del cliente", example = "123-123-1234")
    private String phone;

    @Schema(description = "Identificador para ingresar el email del cliente",example = "ana@mail.com")
    private String email;

    public String getNombreCompleto(){
        return name + " " + lastname;
    }

}
