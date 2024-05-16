package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Departamento;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DepartamentoServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired
	private DoctorServicio doctorServicio;
	
	@Autowired
	private DepartamentoServicio departamentoServicio;

	@GetMapping("/mostrarDoctores")
	public String doctores(Model model) {
		model.addAttribute("doctores", doctorServicio.findAll());
		return "admin/tablaDoctores";
	}
	
	@GetMapping("/nuevoDoctor")
	public String mostrarFormularioDoctores(Model model) {

		List<Departamento> departamentos = departamentoServicio.findAll();
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("doctor", new Doctor());

		return "admin/formularioDoctor";
	}

	@PostMapping("/nuevoDoctor/submit")
	public String postMethodName(@ModelAttribute("doctor") Doctor doctor) {

		doctorServicio.save(doctor);

		return "redirect:/admin/mostrarDoctores";
	}

}
