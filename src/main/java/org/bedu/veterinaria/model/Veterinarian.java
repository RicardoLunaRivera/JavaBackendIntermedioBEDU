package org.bedu.veterinaria.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Entity
@Table (name= "veterinarians")
public class Veterinarian {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id_veterinarian")
    private Long idVeterinarian;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastname;

    @Column()
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date schedule;

    @Column(nullable = false, length = 13)
    private String phone;

    @Column(length = 30)
    private String specialty;

  public void setSchedule(String date) {
      //Metodo creado para pruebas
  }
}