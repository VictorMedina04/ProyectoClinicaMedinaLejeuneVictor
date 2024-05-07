package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {

	@Id
	@GeneratedValue
	private long idSeguro;
	
	private String nombre;
	private double precio;
	private String descripcion;
	//private PagoSeguro List<PagoSeguro> pagos;
	
}
