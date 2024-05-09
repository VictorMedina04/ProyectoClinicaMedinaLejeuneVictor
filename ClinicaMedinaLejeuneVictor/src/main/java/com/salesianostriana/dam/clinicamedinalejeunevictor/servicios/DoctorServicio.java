package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.DoctorPk;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.DoctorRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class DoctorServicio extends BaseServiceImpl<Doctor, DoctorPk, DoctorRepositorio> {

}
