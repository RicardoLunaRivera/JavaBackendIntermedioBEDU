package org.bedu.veterinaria.dto.veterinarianDTO;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
public class VeterinarianDTO {

    @Schema(description = "Identificador del veterinario", example = "10")
    private Long idVeterinarian;

    @Schema(description = "Identificador para ingresar el nombre del veterinario", example = "Pablo")
    private String name;

    @Schema(description = "Identificador para ingresar el apellido del veterinario", example = "Martinez")
    private String lastname;

    @Schema(description = "Identificador para ingresar el horario de cita del veterinario", example = "2023-05-18 16:18")
    private String schedule;

    @Schema(description = "Identificador para ingresar el telefono del veterinario", example = "111-111-1111")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @Schema(description = "Identificador para ingresar la especialidad del veterinario", example = "Cardiologo")
    private String specialty;
}
