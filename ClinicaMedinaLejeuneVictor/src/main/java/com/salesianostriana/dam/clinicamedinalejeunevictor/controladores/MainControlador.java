package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.ClienteServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;

@Controller
public class MainControlador {

	@Autowired
	private DoctorServicio doctorServicio;

	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping("/")
	public String inicioSinLogin() {
		return "inicioSinLog";
	}

	@GetMapping("/novedades")
	public String novedades() {
		return "novedades";
	}

	@GetMapping("/nuestrosLogros")
	public String nuestrosLogros() {
		return "nuestrosLogros";
	}

	@GetMapping("/doctores")
	public String doctoresSinLog(Model model) {
		model.addAttribute("doctores", doctorServicio.findAll());
		return "doctores";
	}

	@GetMapping("/buscarDoctor")
	public String buscarDoctorPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
		model.addAttribute("doctores", doctorServicio.buscarPorNombre(busqueda));
		return "doctores";
	}

	@GetMapping("/login")
	public String formLogin() {
		return "login";
	}

	@GetMapping("/nuevoCliente")
	public String mostrarFormulario(Model model) {
		model.addAttribute("clienteForm", new Cliente());
		return "registroCliente";
	}

	@PostMapping("/nuevoCliente/submit")
	public String procesarFormulario(@ModelAttribute("clienteForm") Cliente cliente) {
		clienteServicio.save(cliente);
		return "redirect:/";
	}

}