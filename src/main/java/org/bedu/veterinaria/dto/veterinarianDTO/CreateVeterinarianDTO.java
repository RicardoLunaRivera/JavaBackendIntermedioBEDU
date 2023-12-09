package org.bedu.veterinaria.dto.veterinarianDTO;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateVeterinarianDTO {
    @NotEmpty(message = "Missing name, required field")
    private String name;

    @NotEmpty(message = "Missing lastname, required field")
    private String lastname;

    @NotEmpty(message = "Missing Schedule")
    private LocalDateTime schedule;

    @NotEmpty(message = "Missing phone")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @NotEmpty(message = "Missing specialty")
    private String specialty;

}
