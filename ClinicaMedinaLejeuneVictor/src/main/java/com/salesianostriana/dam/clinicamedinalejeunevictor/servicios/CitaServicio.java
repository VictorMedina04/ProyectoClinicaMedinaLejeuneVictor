package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.CitasPk;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.CitaRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class CitaServicio extends BaseServiceImpl<Cita, CitasPk, CitaRepositorio> {

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
}
