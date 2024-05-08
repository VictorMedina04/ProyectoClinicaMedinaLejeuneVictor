package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
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
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "departamento",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Doctor> doctores;
	
	// MÉTODOS HELPER
	
		public void addDoctor(Doctor doctor) {
			doctor.setDepartamento(this);
			this.doctores.add(doctor);
		}
		
		public void removeAsiento(Doctor doctor) {
			this.doctores.remove(doctor);
			
		}
}
