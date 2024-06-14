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
}
