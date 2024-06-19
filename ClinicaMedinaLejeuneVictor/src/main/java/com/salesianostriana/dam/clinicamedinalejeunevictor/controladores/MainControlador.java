package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Seguro;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.SeguroServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.UsuarioServicio;

@Controller
public class MainControlador {

	@Autowired
	private DoctorServicio doctorServicio;

	@Autowired
	private SeguroServicio seguroServicio;

	@Autowired
	private UsuarioServicio usuarioServicio;

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
	public String buscarDoctorPorNombreYApellido(Model model, @RequestParam("busqueda") String busqueda) {

		model.addAttribute("doctores", doctorServicio.buscarPorNombreYApellido(busqueda));

		return "doctores";
	}

	@GetMapping("/login")
	public String formLogin() {
		return "login";
	}

	@GetMapping("/nuevoCliente")
	public String mostrarFormulario(Model model) {
		List<Seguro> seguros = seguroServicio.findAll();
		model.addAttribute("seguros", seguros);
		model.addAttribute("clienteForm", new Cliente());
		return "registroCliente";
	}

	@PostMapping("/nuevoCliente/submit")
	public String procesarFormulario(@ModelAttribute("clienteForm") Cliente cliente) {

		if (usuarioServicio.encontrarPorUsername(cliente.getUsername())) {
			return "errorUsername";
		}

		usuarioServicio.codificarContrasenya(cliente.getPassword(), cliente);
		usuarioServicio.save(cliente);

		return "redirect:/";
	}
}