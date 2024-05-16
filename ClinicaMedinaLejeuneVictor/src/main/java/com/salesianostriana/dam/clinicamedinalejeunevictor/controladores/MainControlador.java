package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;

@Controller
public class MainControlador {

	@Autowired
	private DoctorServicio doctorServicio;

	@GetMapping("/")
	public String inicioSinLogin() {
		return "inicioSinLog";
	}

	@GetMapping("/login")
	public String formLogin() {
		return "login";
	}

	@GetMapping("/doctores")
	public String doctoresSinLog(Model model) {
		model.addAttribute("doctores", doctorServicio.findAll());
		return "doctores";
	}
}
