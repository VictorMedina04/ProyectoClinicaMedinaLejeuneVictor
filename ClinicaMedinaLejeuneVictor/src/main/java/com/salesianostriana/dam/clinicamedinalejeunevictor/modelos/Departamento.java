package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.ArrayList;
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

	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Doctor> doctores = new ArrayList();

}
