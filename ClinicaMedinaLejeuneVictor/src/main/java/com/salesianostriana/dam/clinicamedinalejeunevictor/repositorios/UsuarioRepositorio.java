package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByUsername(String username);
}
