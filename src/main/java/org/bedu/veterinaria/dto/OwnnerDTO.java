package org.bedu.veterinaria.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class OwnnerDTO {
    private Long idOwner;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;

}
