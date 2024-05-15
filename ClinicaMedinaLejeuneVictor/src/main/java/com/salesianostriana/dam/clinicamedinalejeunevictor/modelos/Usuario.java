package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	private String username;
	private String nombre;
	private String apellidos;
	private String gmail;
	private String password;
	private String dni;
	private boolean esAdmin;
	private boolean esDoctor;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";

		if (esAdmin) {
			role += "ADMIN";
		} else if (esDoctor) {
			role += "DOCTOR";
		}

		if (!esAdmin && !esDoctor) {
			role += "CLIENTE";
		}

		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}
}
