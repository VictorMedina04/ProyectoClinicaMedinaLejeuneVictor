package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
