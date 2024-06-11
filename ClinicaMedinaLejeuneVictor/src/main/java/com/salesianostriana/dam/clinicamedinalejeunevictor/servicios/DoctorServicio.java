package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.exceptions.DoctorNotFoundException;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.DoctorRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class DoctorServicio extends BaseServiceImpl<Doctor, Long, DoctorRepositorio> {

	public List<Doctor> buscarPorNombre(String busqueda) {
		List<Doctor> result = this.repository.findByNombreContainsIgnoreCase(busqueda);
		if (result.isEmpty()) {
			throw new DoctorNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
}
