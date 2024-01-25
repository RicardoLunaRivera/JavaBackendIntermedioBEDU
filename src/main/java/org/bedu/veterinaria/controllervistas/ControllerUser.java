package org.bedu.veterinaria.controllervistas;

import jakarta.validation.Valid;
import org.bedu.veterinaria.model.Usuario;
import org.bedu.veterinaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/users")
public class ControllerUser {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String usuarios(Model model){
        var users = usuarioService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String agregar(Usuario usuario){
        return "createuser";
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(@Valid Usuario usuario, Errors errors) {
        if (errors.hasErrors()) {
            return "createuser";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario result = usuarioService.save(usuario);
        if (result.getIdUsuario() > 0) {
            System.out.println("Usuario Guardado");
        }else {
            System.out.println("Error, Usuario no guardado");

        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{idUser}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String update(Usuario usuario, Model model){
        usuario = usuarioService.findById(usuario);
        model.addAttribute("usuario", usuario);
        return "modifyuser";
    }

    @GetMapping("/delete/{idUser}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String eliminar(Usuario usuario){
        usuarioService.delete(usuario);
        return "redirect:/users";
    }

    public UserDetails getLoggedInUserDateils(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }
}
