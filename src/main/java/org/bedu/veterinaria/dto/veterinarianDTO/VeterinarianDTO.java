package org.bedu.veterinaria.dto.veterinarianDTO;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VeterinarianDTO {

    @Schema(description = "Identificador del veterinario", example = "10")
    private Long idVeterinarian;

    @Schema(description = "Identificador para ingresar el nombre del veterinario", example = "Pablo")
    private String name;

    @Schema(description = "Identificador para ingresar el apellido del veterinario", example = "Martinez")
    private String lastname;

    @Schema(description = "Identificador para ingresar el horario de cita del veterinario", example = "20-12-2023 14:30:00")
    private LocalDateTime schedule;

    @Schema(description = "Identificador para ingresar el telefono del veterinario", example = "111-111-1111")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @Schema(description = "Identificador para ingresar la especialidad del veterinario", example = "Cardiologo")
    private String specialty;
}
