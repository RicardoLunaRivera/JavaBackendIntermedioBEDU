package org.bedu.veterinaria.dto.veterinarian_dto;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateVeterinarianDTO {

    @Schema(description = "Identificador para ingresar el nombre del veterinario", example = "Pablo")
    @NotEmpty(message = "Missing name, required field")
    private String name;

    @Schema(description = "Identificador para ingresar el apellido del veterinario", example = "Martinez")
    @NotEmpty(message = "Missing lastname, required field")
    private String lastname;

    @Schema(description = "Identificador para ingresar el horario de cita del veterinario", example = "2023-12-09T12:13")
//    @NotEmpty(message = "Missing Schedule")
    private Date schedule;

    @Schema(description = "Identificador para ingresar el telefono del veterinario", example = "111-111-1111")
    @NotEmpty(message = "Missing phone")
    @Pattern(regexp = "^(\\d{3}-?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @Schema(description = "Identificador para ingresar la especialidad del veterinario", example = "Cardiologo")
    @NotEmpty(message = "Missing specialty")
    private String specialty;

  public void setSchedule(String s) {
      // Metodo creado para pruebas unitarias
  }
}
