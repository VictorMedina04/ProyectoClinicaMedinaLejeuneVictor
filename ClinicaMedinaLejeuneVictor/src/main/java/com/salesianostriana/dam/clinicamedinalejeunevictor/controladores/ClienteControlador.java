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
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.CitaServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.ClienteServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.SeguroServicio;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private SeguroServicio seguroServicio;

	@Autowired
	private ClienteServicio clienteServicio;

	@Autowired
	private DoctorServicio doctorServicio;

	@Autowired
	private CitaServicio citaServicio;

	@GetMapping("/citas")
	public String mostrarFormularioCita(Model model) {

		model.addAttribute("doctores", doctorServicio.findAll());

		model.addAttribute("cita", new Cita());

		return "cliente/pedirCitas";
	}

	@PostMapping("/citas/submit")
	public String procesarFormularioCitas(@ModelAttribute("cita") Cita cita, @AuthenticationPrincipal Cliente cliente) {

		citaServicio.ponerPreciosBase(cita);

		cita.getCitasPk().setId_cliente(cliente.getId());
		cita.getCitasPk().setId_doctor(cita.getDoctor().getId());

		

		cita.addToDoctor(cita.getDoctor());
		cita.addToCliente(cliente);

		citaServicio.save(cita);

		doctorServicio.aumentarSalarioPorNumCita(cita.getDoctor());

		return "redirect:/cliente/historialCitas";
	}

	@GetMapping("/historialCitas")
	public String mostrarHistorialCliente(@AuthenticationPrincipal Cliente cliente, Model model) {

		model.addAttribute("citasCliente", cliente.getCitas());

		return "/cliente/historialCitas";
	}

	@GetMapping("/borrarCita/{id_doctor}/{id_cliente}/{fecha_inicio}")
	public String borrarCita(@PathVariable("id_doctor") long id_doctor, @AuthenticationPrincipal Cliente cliente,
			@PathVariable("fecha_inicio") LocalDateTime fecha_inicio, Model model) {

		CitasPk citaId = new CitasPk(id_doctor, cliente.getId(), fecha_inicio);

		Optional<Cita> borrarCita = citaServicio.findById(citaId);

		clienteServicio.borrarCitaCliente(cliente, borrarCita.get());

		return "redirect:/cliente/historialCitas";
	}

	@GetMapping("/seguros")
	public String mostrarSeguros(Model model, @AuthenticationPrincipal Cliente cliente) {

		model.addAttribute("cliente", cliente);

		model.addAttribute("seguros", seguroServicio.findAll());

		return "/cliente/seguros";
	}

	// confirmar edicion cliente
	@PostMapping("/seguros/submit")
	public String procesarFormularioEdicionCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServicio.edit(cliente);
		return "inicioSinLog";
	}

}
