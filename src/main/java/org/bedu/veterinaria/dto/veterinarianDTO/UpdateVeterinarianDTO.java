package org.bedu.veterinaria.dto.veterinarianDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UpdateVeterinarianDTO {

    @Id
    private Long idVeterinarian;

    @Schema(description = "Identificador para ingresar el nombre del veterinario", example = "Pablo")
    @NotEmpty(message = "Missing name, required field")
    private String name;

    @Schema(description = "Identificador para ingresar el apellido del veterinario", example = "Martinez")
    @NotEmpty(message = "Missing lastname, required field")
    private String lastname;

    @Schema(description = "Identificador para ingresar el horario de cita del veterinario", example = "2023-05-18 18:30")
//    @NotEmpty(message = "Missing Schedule")
    private String schedule;

    @Schema(description = "Identificador para ingresar el telefono del veterinario", example = "111-111-1111")
    @NotEmpty(message = "Missing phone")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @Schema(description = "Identificador para ingresar la especialidad del veterinario", example = "Cardiologo")
    @NotEmpty(message = "Missing specialty")
    private String specialty;

}

