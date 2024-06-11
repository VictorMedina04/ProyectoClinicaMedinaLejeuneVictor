package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Usuario;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.UsuarioRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class UsuarioServicio extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

	@Autowired
	UsuarioRepositorio repo;

	@Autowired
	private PasswordEncoder encoder;

	public boolean encontrarPorUsername(String username) {

		Optional<Usuario> usuarioOptional = repo.findFirstByUsername(username);

		if (usuarioOptional.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	public void codificarContrasenya(String password, Usuario usuario) {
		String codePassword = encoder.encode(password);
		usuario.setPassword(codePassword);
	}

}
