package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class CitasPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idDoctor;
	private long idCliente;

}
