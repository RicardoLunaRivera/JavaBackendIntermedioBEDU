package org.bedu.veterinaria.controllervistas;

import jakarta.validation.Valid;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Usuario;
import org.bedu.veterinaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String usuarios(Model model){
        var usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/agregar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String agregar(Usuario usuario){
        return "crearusuario";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(@Valid Usuario usuario, Errors errors){
        if (errors.hasErrors()){
            return "crearusuario";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{idUsuario}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String update(Usuario usuario, Model model){
        usuario = usuarioService.findById(usuario);
        model.addAttribute("usuario", usuario);
        return "crearusuario";
    }

    @GetMapping("/eliminar/{idUsuario}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String eliminar(Usuario usuario){
        usuarioService.delete(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/buscarN")
    public String buscarPorPalabra(Model model, @Param("buscarPorPalabra")String buscarPorPalabra){
        List<Usuario> usuariosFiltrados = usuarioService.findByPalabra(buscarPorPalabra);
        model.addAttribute("usuarios", usuariosFiltrados);
        model.addAttribute("buscarPorPalabra", buscarPorPalabra);
        return "ownersv";
    }

    public UserDetails getLoggedInUserDateils(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }

}
