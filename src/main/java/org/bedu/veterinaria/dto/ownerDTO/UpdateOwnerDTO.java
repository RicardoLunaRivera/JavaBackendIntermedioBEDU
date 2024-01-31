package org.bedu.veterinaria.dto.ownerDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateOwnerDTO {

  @Schema(description = "Identificador para ingresar el nombre del cliente", example = "Ana")
  @NotEmpty(message = "El nombre del cliente no puede estar vacío")
  private String name;

  @Schema(description = "Identificador para ingresar el apellido del cliente", example = "Mena")
  @NotEmpty(message = "El apellido del cliente no puede estar vacío")
  private String lastname;

  @Schema(description = "Identificador para ingresar el domicilio del cliente",example = "Calle rio 123")
  @NotEmpty(message = "Debe de ingresar un domicilo")
  private String address;

  @Schema(description = "Identificador para ingresar el telefono del cliente", example = "123-123-1234")
  @NotEmpty(message = "Debe de ingresar un telefono")
  @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
  private String phone;

  @Schema(description = "Identificador para ingresar el email del cliente",example = "ana@mail.com")
  @NotNull
  @Email
  private String email;
}
