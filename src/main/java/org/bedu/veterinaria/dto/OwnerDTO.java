package org.bedu.veterinaria.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class OwnerDTO {
    private Long idOwner;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;

}
