package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;

public interface DoctorRepositorio extends JpaRepository<Doctor, Long> {

	List<Doctor> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String apellidos);

}
