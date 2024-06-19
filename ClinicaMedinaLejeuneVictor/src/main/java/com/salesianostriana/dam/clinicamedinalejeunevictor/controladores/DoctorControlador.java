package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.CitasPk;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.CitaServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.ClienteServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;

@Controller
@RequestMapping("/doctor")

public class DoctorControlador {

	@Autowired
	private ClienteServicio clienteServicio;

	@Autowired
	private DoctorServicio doctorServicio;

	@Autowired
	private CitaServicio citaServicio;

	@GetMapping("/citas")
	public String mostrarFormularioCita(Model model) {

		model.addAttribute("clientes", clienteServicio.findAll());
		model.addAttribute("cita", new Cita());

		return "doctor/pedirCitas";
	}

	@PostMapping("/citas/submit")
	public String procesarFormularioCitas(@ModelAttribute("cita") Cita cita, @AuthenticationPrincipal Doctor doctor,
			Model model) {

		cita.setDoctor(doctor);

		cita.getCitasPk().setId_cliente(cita.getCliente().getId());
		cita.getCitasPk().setId_doctor(doctor.getId());


		if(!citaServicio.esCitaUnica(cita.getCitasPk())) {
			return "/errorCita";
		}
		
		citaServicio.save(cita);

		// especial
		citaServicio.ponerPreciosBase(cita);

		// duracion
		double precioDuracion = citaServicio.rebajarPrecioPorDuracion(cita);
		cita.setPrecioCita(precioDuracion);
		// seguro
		double precioPorSeguro = clienteServicio.hacerDescuentoPorSeguro(cita);

		// num citas
		int contadorCitas = clienteServicio.contarCitasCliente(cita.getCliente());
		int limite = 2;

		boolean aplicarRebajaPorNumeroCitas;
		double total = precioPorSeguro;

		if (aplicarRebajaPorNumeroCitas = (contadorCitas > limite)) {
			total = precioPorSeguro - precioPorSeguro * 10 / 100;
		}

		cita.setPrecioCita(total);
		model.addAttribute("seguro", cita.getCliente().getSeguro());
		model.addAttribute("precioDuracion", precioDuracion);
		model.addAttribute("precioPorSeguro", precioPorSeguro);
		model.addAttribute("aplicarRebaja", aplicarRebajaPorNumeroCitas);

		cita.addToDoctor(doctor);
		cita.addToCliente(cita.getCliente());
		citaServicio.save(cita);

		return "doctor/pantallaPago";
	}

	@GetMapping("/pantallaPago")
	public String mostrarPantallaPago() {
		return "doctor/pantallaPago";
	}

	@GetMapping("/historialCitas")
	public String mostrarHistorialCliente(@AuthenticationPrincipal Doctor doctor, Model model) {

		model.addAttribute("citasDoctor", doctor.getCitas());

		return "doctor/historialCitas";
	}

	@GetMapping("/borrarCita/{id_doctor}/{id_cliente}/{fecha_inicio}")
	public String borrarCita(@PathVariable("id_cliente") long id_cliente, @AuthenticationPrincipal Doctor doctor,
			@PathVariable("fecha_inicio") LocalDateTime fecha_inicio) {

		CitasPk citaId = new CitasPk(doctor.getId(), id_cliente, fecha_inicio);

		Optional<Cita> borrarCita = citaServicio.findById(citaId);

		doctorServicio.borrarCitaDoctor(doctor, borrarCita.get());

		return "redirect:/doctor/historialCitas";
	}
}
