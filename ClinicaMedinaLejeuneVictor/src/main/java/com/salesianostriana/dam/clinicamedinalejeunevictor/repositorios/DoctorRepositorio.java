package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;

public interface DoctorRepositorio extends JpaRepository<Doctor, Long> {

	// encontrar doctor por nombre y apellido
	List<Doctor> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String apellidos);

	// encontrar a los jefes de departamento
	@Query("""
			SELECT d
			FROM Doctor d
			WHERE d.indJefe = true
			""")
	List<Doctor> findByIndJefe();

	// encontrar a los no jefes de departamento
	@Query("""
			SELECT d
			FROM Doctor d
			WHERE d.indJefe = false
			""")
	List<Doctor> findByNoIndJefe();
}
