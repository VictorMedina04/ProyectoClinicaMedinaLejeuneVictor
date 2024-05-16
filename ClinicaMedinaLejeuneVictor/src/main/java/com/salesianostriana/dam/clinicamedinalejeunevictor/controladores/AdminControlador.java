package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired
	private DoctorServicio doctorServicio;

	@GetMapping("/mostrarDoctores")
	public String doctores(Model model) {
		model.addAttribute("doctores", doctorServicio.findAll());
		return "admin/tablaDoctores";
	}
}
