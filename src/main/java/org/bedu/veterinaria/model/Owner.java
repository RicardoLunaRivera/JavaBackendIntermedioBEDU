package org.bedu.veterinaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_owner")
    private long idOwner;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastname;

    @Column(length = 100)
    private String address;

    @Column(nullable = false,length = 13)
    private String phone;

    @Column(nullable = false, length = 30)
    @Email
    private String email;


}
