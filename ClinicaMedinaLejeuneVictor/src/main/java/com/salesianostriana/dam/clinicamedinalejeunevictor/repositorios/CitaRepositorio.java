package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.CitasPk;

public interface CitaRepositorio extends JpaRepository<Cita, CitasPk> {

}
