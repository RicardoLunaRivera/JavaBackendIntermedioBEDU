package org.bedu.veterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOwner;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String lastname;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false,length = 10)
    private String phone;

    @Column(nullable = false, length = 30)
    private String email;


}
