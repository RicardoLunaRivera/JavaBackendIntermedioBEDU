package org.bedu.veterinaria.service;

import org.bedu.veterinaria.model.Usuario;
import org.bedu.veterinaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario save(Usuario usuario) {

        return usuario;
    }


    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }


    public Usuario findById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
    }


    public List<Usuario> findByNombre(String palabraClave) {
        if (palabraClave != null){
            return usuarioRepository.findByNombre(palabraClave);
        }
        return (List<Usuario>) usuarioRepository.findAll();
    }



    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }


    public Usuario deleteById(Long id) {
        usuarioRepository.deleteById(id);
        return null;
    }


    public Usuario findByClienteId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
