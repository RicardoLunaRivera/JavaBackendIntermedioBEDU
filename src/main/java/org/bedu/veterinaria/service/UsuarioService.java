package org.bedu.veterinaria.service;

import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Usuario;
import org.bedu.veterinaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void update(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario findById(Usuario usuario){
        return usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
    }

    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> findByPalabra(String palabra) {
        if(palabra != null){
            return usuarioRepository.findByPalabra(palabra);
        }
        return usuarioRepository.findAll();
    }

}
