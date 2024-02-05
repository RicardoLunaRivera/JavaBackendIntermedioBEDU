package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select * from usuarios where email = ?1", nativeQuery = true)
    Optional<Usuario> findByEmail(String email);

    @Query("select u from Usuario u where concat(u.email, u.roles, u.idUsuario) like %?1%")
    List<Usuario> findByPalabra(String Palabra);
}
