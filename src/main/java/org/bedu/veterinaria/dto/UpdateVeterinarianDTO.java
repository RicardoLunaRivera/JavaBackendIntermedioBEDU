package org.bedu.veterinaria.dto;

public class UpdateVeterinarianDTO {
    @Id
    private Long idVeterinarian;

    @NotEmpty(message = "Missing Name")
    private String name;

    @NotEmpty(message = "Missing LastName")
    private String lastname;

    @NotEmpty(message = "Missing Schedule")
    private LocalDateTime schedule;

    @NotEmpty(message = "Debe de ingresar un telefono")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$") //formato ###-###-####
    private String phone;

    @NotEmpty(message = "Missing Specialty")
    private String specialty;
}
