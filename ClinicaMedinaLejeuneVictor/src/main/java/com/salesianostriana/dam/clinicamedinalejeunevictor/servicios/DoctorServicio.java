package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.exceptions.DoctorNotFoundException;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.DoctorRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class DoctorServicio extends BaseServiceImpl<Doctor, Long, DoctorRepositorio> {

	@Autowired
	private CitaServicio citaServicio;

	@Autowired
	private DoctorRepositorio doctorRepositorio;

	public List<Doctor> buscarPorNombreYApellido(String busqueda) {
		List<Doctor> result = this.repository.findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(busqueda,
				busqueda);
		if (result.isEmpty()) {
			throw new DoctorNotFoundException("No hay doctores con ese criterio");
		}
		return result;
	}

	public void borrarCitaDoctor(Doctor doctor, Cita cita) {

		doctor.getCitas().remove(cita);

	}

	// metodo si el doctor a llegado a x num de citas se le aumente el salario un
	// 5%
	public void aumentarSalarioPorNumCita(Doctor doctor) {

		int numCitas = citaServicio.contarCitasDoctor(doctor.getId());
		double nuevoSalario;
		int limite = 5;

		if (numCitas > limite) {
			nuevoSalario = doctor.getSalario() + doctor.getSalario() * 5 / 100;
			doctor.setSalario(nuevoSalario);
		}
	}

	// metodo de que si el doctor es jefe de departamento tenga un 5% mas de salario
	public void aumentarSalarioSiEsJefe() {
		List<Doctor> listaJefes = doctorRepositorio.findByIndJefe();

		double nuevoSalario;

		for (Doctor doctor2 : listaJefes) {

			nuevoSalario = doctor2.getSalario() + doctor2.getSalario() * 5 / 100;
			doctor2.setSalario(nuevoSalario);
		}
	}

	public void ponerSalarioNoJefe() {

		List<Doctor> listaNoJefes = doctorRepositorio.findByNoIndJefe();

		double salarioBase = 200;
		for (Doctor doctor : listaNoJefes) {
			doctor.setSalario(salarioBase);
		}

	}

}
