package org.bedu.veterinaria.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOwnerDTO {

  @Id
  private Long idOwner;

  @NotEmpty(message = "El nombre del cliente no puede estar vacío")
  private String name;

  @NotEmpty(message = "El apellido del cliente no puede estar vacío")
  private String lastname;

  @NotEmpty(message = "Debe de ingresar un domicilo")
  private String address;

  @NotNull
  private String phone;

  @NotNull
  @Email
  private String email;
}
