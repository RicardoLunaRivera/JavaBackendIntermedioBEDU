package org.bedu.veterinaria;

import org.bedu.veterinaria.model.Usuario;
import org.bedu.veterinaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {
			Usuario usuario = Usuario.builder()
					.email("admin@gmail.com")
					.password(passwordEncoder.encode("123456789"))
					.roles("ADMIN")
					.build();
			usuarioRepository.save(usuario);
		};
	}


}

