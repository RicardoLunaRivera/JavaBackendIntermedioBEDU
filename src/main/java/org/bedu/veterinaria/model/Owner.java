package org.bedu.veterinaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,name = "id_owner")
    private Long idOwner;

    @Column(nullable = false,length = 30)
    private String name;

    @Column(nullable = false,length = 30)
    private String lastname;

    @Column(nullable = false,length = 100)
    private String address;

    @Column(nullable = false,length = 13)
    private String phone;

    @Column(nullable = false, length = 30)
    @Email
    private String email;


}
