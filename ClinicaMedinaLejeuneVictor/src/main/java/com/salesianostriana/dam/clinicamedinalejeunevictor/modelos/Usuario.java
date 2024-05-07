package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@MappedSuperclass
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellido;
	private String gmail;
	private String contrasenya;
	private String dni;
}
