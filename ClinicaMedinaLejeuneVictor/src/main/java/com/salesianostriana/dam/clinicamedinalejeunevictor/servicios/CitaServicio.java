package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.CitasPk;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.CitaRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class CitaServicio extends BaseServiceImpl<Cita, CitasPk, CitaRepositorio> {

	@Autowired
	private CitaRepositorio citaRepositorio;

	@Transactional
	@Override
	public Cita edit(Cita t) {

		return repository.save(t);

	}

	public void ponerPreciosBase(Cita cita) {

		double precioCitaNormal = 40;
		double precioCitaEspecial = 60;

		if (cita.isEspecial()) {
			cita.setPrecioCita(precioCitaEspecial);
		} else if (!cita.isEspecial()) {
			cita.setPrecioCita(precioCitaNormal);
		}
	}

	// buscar por departamento
	public List<Cita> buscarPorDepartamento(Cita cita) {

		Long idDepartamento = cita.getDoctor().getDepartamento().getIdDepartamento();

		return citaRepositorio.findByDepartamento(idDepartamento);
	}

	// contar citas doctor
	public int contarCitasDoctor(Long id) {
		return citaRepositorio.countByDoctor(id);
	}

	// contar citas cliente
	public int contarCitasCliente(Long id) {
		return citaRepositorio.countByCliente(id);
	}
	
	// metodos de duracion
	public double rebajarPrecioPorDuracion(Cita cita) {
		

		int duracionCita = cita.getDuracion();
		double nuevoPrecioDuracion = cita.getPrecioCita();
		
		switch(duracionCita) {
	
		case 30:
			nuevoPrecioDuracion =cita.getPrecioCita() + cita.getPrecioCita() * 5/100;
			break;
		case 45:
			nuevoPrecioDuracion =cita.getPrecioCita() + cita.getPrecioCita() * 10/100;

			break;
		case 60:
			nuevoPrecioDuracion =cita.getPrecioCita() + cita.getPrecioCita() * 15/100;

			break;
		}

		return nuevoPrecioDuracion;
	}

	

}
