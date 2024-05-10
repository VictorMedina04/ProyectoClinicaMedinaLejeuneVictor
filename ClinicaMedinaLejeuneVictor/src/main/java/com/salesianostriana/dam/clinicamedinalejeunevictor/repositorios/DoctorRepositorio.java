package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;

public interface DoctorRepositorio extends JpaRepository<Doctor, Long> {

}
