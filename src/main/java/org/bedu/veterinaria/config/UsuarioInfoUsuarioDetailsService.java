package org.bedu.veterinaria.config;

import org.bedu.veterinaria.model.Usuario;
import org.bedu.veterinaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class UsuarioInfoUsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByEmail(username);
        return user.map(UsuarioInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
    }
}
