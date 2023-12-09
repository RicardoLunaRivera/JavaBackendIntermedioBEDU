package org.bedu.veterinaria.dto;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VeterinarianDTO {
    private Long idVeterinarian;
    private String name;
    private String lastname;
    private LocalDateTime schedule;
    private String phoneNumber;
    private String specialty;
}
