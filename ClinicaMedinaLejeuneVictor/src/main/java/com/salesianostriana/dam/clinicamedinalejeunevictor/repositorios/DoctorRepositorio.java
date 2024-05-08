package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.DoctorPk;

public interface DoctorRepositorio extends JpaRepository<Doctor, DoctorPk> {

}
