package org.bedu.veterinaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(unique = true)
    @Email
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacia y debe ser minimo 8 caracteres")
    @Size(min = 8)
    private String password;

    @NotBlank(message = "El rol no puede estar vacio y deben ser mayusculas")
    private String roles;
}
