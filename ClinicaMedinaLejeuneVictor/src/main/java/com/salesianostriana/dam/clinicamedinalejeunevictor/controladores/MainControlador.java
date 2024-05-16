package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {

	@GetMapping("/")
	public String inicioSinLogin() {
		return "inicioSinLog";
	}

	@GetMapping("/login")
	public String formLogin() {
		return "login";
	}
}
