package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	private int numFaltas;
	private int tipoSeguro;
}
