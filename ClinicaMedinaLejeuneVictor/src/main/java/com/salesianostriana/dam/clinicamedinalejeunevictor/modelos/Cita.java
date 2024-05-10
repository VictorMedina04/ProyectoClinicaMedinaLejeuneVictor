package com.salesianostriana.dam.clinicamedinalejeunevictor.modelos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cita {

	@EmbeddedId
	private CitasPk citasPk = new CitasPk();

	@ManyToOne
	@MapsId("idDoctor")
	@JoinColumn(name = "idDoctor")
	private Doctor doctor;

	@ManyToOne
	@MapsId("idCliente")
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@DateTimeFormat(pattern = "MM-dd-HH")
	private LocalDateTime fechaInicio;
	@DateTimeFormat(pattern = "MM-dd-HH")
	private LocalDateTime fechaFin;
	private boolean especial;

	// Helper doctor
	public void addToDoctor(Doctor doctor) {
		doctor.getCitas().add(this);
		this.doctor = doctor;
	}

	public void removeFromDoctor(Doctor doctor) {
		doctor.getCitas().remove(this);
		this.doctor = null;
	}

	// Helper cliente
	public void addToCliente(Cliente cliente) {
		cliente.getCitas().add(this);
		this.cliente = cliente;
	}

	public void removeFromAlumno(Cliente cliente) {
		cliente.getCitas().remove(this);
		this.cliente = null;
	}
}
