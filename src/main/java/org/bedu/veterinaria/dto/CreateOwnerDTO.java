package org.bedu.veterinaria.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOwnerDTO {
    @NotBlank
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @NotNull
    private String email;
}
