package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Usuario {

	private int numFaltas;
	private int tipoSeguro;
}
