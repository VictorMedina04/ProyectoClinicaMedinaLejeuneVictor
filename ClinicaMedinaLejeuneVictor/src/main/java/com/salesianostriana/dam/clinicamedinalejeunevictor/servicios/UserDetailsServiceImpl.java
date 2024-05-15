//package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;
//
//import org.springframework.stereotype.Service;
//
//import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.UsuarioRepositorio;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDe {
//
//	private final UsuarioRepositorio repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return repo.findFirstByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
//	}
//}
