package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Doctor extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salario;
	private boolean indJefe;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ToString.Exclude
	private List<Cita> citas = new ArrayList<>();

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_doctor_departamento"))
	private Departamento departamento;

	// Helper departamento
	public void addToDepartamento(Departamento departamento) {
		this.departamento = departamento;
		departamento.getDoctores().add(this);
	}

	public void removeFromDepartamento(Departamento departamento) {
		departamento.getDoctores().remove(this);
		this.departamento = null;
	}

}
