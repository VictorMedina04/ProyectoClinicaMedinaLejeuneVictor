package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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

	private long id_doctor;
	private long id_cliente;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime fecha_inicio;

}
