package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@IdClass(DoctorPk.class)
public class Doctor extends Usuario {

	private double salario;
	private boolean indJefe;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_doctor_departamento"))
	private Departamento departamento;

	public Doctor(UsuarioBuilder<?, ?> b, double salario, boolean indJefe, Departamento departamento) {
		super(b);
		this.salario = salario;
		this.indJefe = indJefe;
		this.departamento = departamento;
	}

}
