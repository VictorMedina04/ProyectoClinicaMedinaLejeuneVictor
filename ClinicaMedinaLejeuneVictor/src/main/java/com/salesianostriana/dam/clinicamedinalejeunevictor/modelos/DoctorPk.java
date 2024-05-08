package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Departamento departamento;
	private Long id;
}
