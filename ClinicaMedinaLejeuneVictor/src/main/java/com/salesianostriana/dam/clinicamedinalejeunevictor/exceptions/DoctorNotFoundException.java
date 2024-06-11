package com.salesianostriana.dam.clinicamedinalejeunevictor.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class DoctorNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException() {
		super("No hay criterios de búsqueda especificados");
	}

	public DoctorNotFoundException(String msg) {
		super("No hay criterios de búsqueda especificados");
	}
}