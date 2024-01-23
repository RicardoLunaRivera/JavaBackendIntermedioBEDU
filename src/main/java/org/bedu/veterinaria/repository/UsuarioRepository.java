package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select * from usuarios where email = ?1",nativeQuery = true)
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE concat(u.email, u.idUsuario, u.roles) like %?1%")
    List<Usuario> findByNombre(String palabraClave);
}
