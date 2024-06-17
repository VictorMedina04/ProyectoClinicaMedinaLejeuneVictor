
package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.ClienteRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class ClienteServicio extends BaseServiceImpl<Cliente, Long, ClienteRepositorio> {

	public void borrarCitaCliente(Cliente cliente, Cita cita) {

		cliente.getCitas().remove(cita);

	}

}
