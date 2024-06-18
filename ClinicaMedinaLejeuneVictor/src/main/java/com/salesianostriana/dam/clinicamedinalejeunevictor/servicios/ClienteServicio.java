
package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.ClienteRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class ClienteServicio extends BaseServiceImpl<Cliente, Long, ClienteRepositorio> {

	@Autowired
	private CitaServicio citaServicio;

	public void borrarCitaCliente(Cliente cliente, Cita cita) {

		cliente.getCitas().remove(cita);

	}

	public void hacerDescuento(Cliente cliente) {

		String seguro = cliente.getSeguro().getNombre().toLowerCase();

		List<Cita> citasCliente = cliente.getCitas();

		double nuevoPrecio;

		switch (seguro) {
		case "Sin seguro" -> nuevoPrecio  {

			for (Cita cita : citasCliente) {
				nuevoPrecio = cita.getPrecioCita();
			}

		}

		case "Seguro Bronce" -> {

			for (Cita cita : citasCliente) {

				if (!cita.isEspecial()) {

					nuevoPrecio = cita.getPrecioCita() - cita.getPrecioCita() * 10 / 100;
					cita.setPrecioCita(nuevoPrecio);
				}
			}
		}

		case "Seguro Plata" -> {

		}

		case "Seguro Oro" -> {

		}

		case "Seguro Platino" -> {

		}

		case "Seguro Paladio" -> {

		}

		default -> {

		}

		}

//		if (seguro == 2) {
//
//			for (Cita cita : citasCliente) {
//
//				if (!cita.isEspecial()) {
//
//					nuevoPrecio = cita.getPrecioCita() - cita.getPrecioCita() * 10 / 100;
//					cita.setPrecioCita(nuevoPrecio);
//				}
//			}
//		}
//
//		if (seguro == 3) {
//
//			for (Cita cita : citasCliente) {
//
//				if (cita.isEspecial()) {
//
//					nuevoPrecio = cita.getPrecioCita() - cita.getPrecioCita() * 15 / 100;
//					cita.setPrecioCita(nuevoPrecio);
//				}
//				if (!cita.isEspecial()) {
//
//					cita.setPrecioCita(0);
//				}
//			}
//
//		}
//
//		if (seguro == 4) {
//
//			for (Cita cita : citasCliente) {
//
//				cita.setPrecioCita(0);
//
//			}
//		}
//
//		if (seguro == 5) {
//
//			for (Cita cita : citasCliente) {
//				List<Cita> citasPorDepartamento = citaServicio.buscarPorDepartamento(cita);
//				for (Cita cita2 : citasPorDepartamento) {
//					nuevoPrecio = cita2.getPrecioCita() - cita2.getPrecioCita() * 45 / 100;
//					cita.setPrecioCita(nuevoPrecio);
//				}
//
//			}
//
//		}
//		if (seguro == 6) {
//
//			for (Cita cita : citasCliente) {
//
//				nuevoPrecio = cita.getPrecioCita() - cita.getPrecioCita() * 50 / 100;
//				cita.setPrecioCita(nuevoPrecio);
//
//			}
//		}

	}

}
