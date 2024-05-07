package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Departamento {

	@Id
	@GeneratedValue
	private long idDepartamento;
	
	private String especialidad;
	
	@OneToMany(mappedBy = "departamento")
	private List<Doctor> doctores;
}
