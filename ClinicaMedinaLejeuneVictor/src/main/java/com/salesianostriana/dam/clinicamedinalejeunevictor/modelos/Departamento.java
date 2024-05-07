package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Departamento {

	@Id
	@GeneratedValue
	private long idDepartamento;
	
	private String especialidad;
	
	@OneToMany(mappedBy = "departamento",
			   fetch = FetchType.EAGER)
	private List<Doctor> doctores;
}
