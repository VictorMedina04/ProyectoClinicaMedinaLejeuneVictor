package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ToString.Exclude
	private List<Cita> citas = new ArrayList<>();
}
