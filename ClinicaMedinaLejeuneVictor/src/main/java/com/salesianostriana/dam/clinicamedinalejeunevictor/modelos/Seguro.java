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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seguro {

	@Id
	@GeneratedValue
	private long idSeguro;

	private String nombre;
	private double precio;
	private String descripcion;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Cliente> clientes;
}
