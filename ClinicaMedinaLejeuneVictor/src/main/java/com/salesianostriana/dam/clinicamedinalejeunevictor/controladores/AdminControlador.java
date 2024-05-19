package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Departamento;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Seguro;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.ClienteServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DepartamentoServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.SeguroServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired
	private DoctorServicio doctorServicio;

	@Autowired
	private DepartamentoServicio departamentoServicio;
	
	@Autowired
	private ClienteServicio clienteServicio;
	
	@Autowired
	private SeguroServicio seguroServicio;

	@GetMapping("/mostrarDoctores")
	public String doctores(Model model) {
		model.addAttribute("doctores", doctorServicio.findAll());
		return "admin/tablaDoctores";
	}

	// formulario doctor
	@GetMapping("/nuevoDoctor")
	public String mostrarFormularioDoctores(Model model) {

		List<Departamento> departamentos = departamentoServicio.findAll();
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("doctor", new Doctor());

		return "admin/formularioDoctor";
	}

	// insertar doctor
	@PostMapping("/nuevoDoctor/submit")
	public String postMethodName(@ModelAttribute("doctor") Doctor doctor) {

		doctorServicio.save(doctor);

		return "redirect:/admin/mostrarDoctores";
	}

	// formulario para editar doctor
	@GetMapping("/editarDoctor/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {

		Optional<Doctor> editarDoctor = doctorServicio.findById(id);
		List<Departamento> departamentos = departamentoServicio.findAll();

		model.addAttribute("departamentos", departamentos);
		model.addAttribute("doctor", editarDoctor.get());

		return "admin/formularioDoctor";
	}

	// confirmar edicion doctor
	@PostMapping("/editarDoctor/submit")
	public String procesarFormularioEdicion(@ModelAttribute("doctor") Doctor doctor) {
		doctorServicio.edit(doctor);
		return "redirect:/admin/mostrarDoctores";
	}

	// borrar doctor
	@GetMapping("/borrarDoctor/{id}")
	public String borrarDoctor(@PathVariable("id") Long id) {

		Optional<Doctor> borrarDoctor = doctorServicio.findById(id);

		doctorServicio.delete(borrarDoctor.get());

		return "redirect:/admin/mostrarDoctores";
	}

	// mostrar tabla clientes
		@GetMapping("/mostrarClientes")
		public String clientes(Model model) {
			model.addAttribute("clientes", clienteServicio.findAll());
			return "admin/tablaClientes";
		}

		// formulario cliente
		@GetMapping("/nuevoCliente")
		public String mostrarFormularioClientes(Model model) {

			List<Seguro> seguros = seguroServicio.findAll();
			model.addAttribute("seguros", seguros);
			model.addAttribute("cliente", new Cliente());

			return "admin/formularioCliente";
		}

		// insertar cliente
		@PostMapping("/nuevoCliente/submit")
		public String nuevoCliente(@ModelAttribute("cliente") Cliente cliente) {

			clienteServicio.save(cliente);

			return "redirect:/admin/mostrarClientes";
		}
		// formulario para editar cliente
		@GetMapping("/editarCliente/{id}")
		public String mostrarFormularioEdicionCliente(@PathVariable("id") Long id, Model model) {

			Optional<Cliente> editarCliente = clienteServicio.findById(id);
			List<Seguro> seguros = seguroServicio.findAll();

			model.addAttribute("seguros", seguros);
			model.addAttribute("cliente", editarCliente.get());

			return "admin/formularioCliente";
		}

		// confirmar edicion cliente
		@PostMapping("/editarCliente/submit")
		public String procesarFormularioEdicionCliente(@ModelAttribute("cliente") Cliente cliente) {
			clienteServicio.edit(cliente);
			return "redirect:/admin/mostrarClientes";
		}
		// borrar Cliente
		@GetMapping("/borrarCliente/{id}")
		public String borrarCliente(@PathVariable("id") Long id) {

			Optional<Cliente> borrarCliente = clienteServicio.findById(id);

			clienteServicio.delete(borrarCliente.get());

			return "redirect:/admin/mostrarClientes";
		}
		
		// mostrar tabla seguros
		@GetMapping("/mostrarSeguros")
		public String seguros(Model model) {
			model.addAttribute("seguros", seguroServicio.findAll());
			return "admin/tablaSeguros";
		}

		// formulario seguro
		@GetMapping("/nuevoSeguro")
		public String mostrarFormularioSeguros(Model model) {

			model.addAttribute("seguro", new Seguro());

			return "admin/formularioSeguro";
		}

		// insertar seguro
		@PostMapping("/nuevoSeguro/submit")
		public String nuevoSeguro(@ModelAttribute("seguro") Seguro seguro) {

			seguroServicio.save(seguro);

			return "redirect:/admin/mostrarSeguros";
		}
		
		// formulario para editar seguro
		@GetMapping("/editarSeguro/{id}")
		public String mostrarFormularioEdicionSeguro(@PathVariable("id") Long id, Model model) {

			Optional<Seguro> editarSeguro = seguroServicio.findById(id);

			model.addAttribute("seguro", editarSeguro.get());

			return "admin/formularioSeguro";
		}

		// confirmar edicion seguro
		@PostMapping("/editarSeguro/submit")
		public String procesarFormularioEdicionSeguro(@ModelAttribute("seguro") Seguro seguro) {
			seguroServicio.edit(seguro);
			return "redirect:/admin/mostrarSeguros";
		}
}
