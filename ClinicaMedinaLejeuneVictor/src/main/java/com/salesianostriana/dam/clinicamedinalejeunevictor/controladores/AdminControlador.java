package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.CitasPk;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Departamento;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Doctor;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Seguro;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.CitaServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.ClienteServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DepartamentoServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.DoctorServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.SeguroServicio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.UsuarioServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired
	private DoctorServicio doctorServicio;

	@Autowired
	private ClienteServicio clienteServicio;

	@Autowired
	private UsuarioServicio usuarioServicio;

	@Autowired
	private DepartamentoServicio departamentoServicio;

	@Autowired
	private SeguroServicio seguroServicio;

	@Autowired
	private CitaServicio citaServicio;

	@Autowired
	private PasswordEncoder encoder;

	// Cosas de doctores
	// mostrar tabla doctores
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
	public String nuevoDoctor(@ModelAttribute("doctor") Doctor doctor,
			@RequestParam(value = "esAdmin", required = false) boolean esAdmin) {

		doctor.setEsDoctor(true);
		doctor.setEsAdmin(esAdmin);

		if (usuarioServicio.encontrarPorUsername(doctor.getUsername())) {

			return "errorUsername";
		}

		usuarioServicio.codificarContrasenya(doctor.getPassword(), doctor);

		usuarioServicio.save(doctor);

		return "redirect:/admin/mostrarDoctores";
	}

	/// formulario para editar doctor
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
	public String procesarFormularioEdicion(@ModelAttribute("doctor") Doctor doctor,
			@RequestParam(value = "esAdmin", required = false) boolean esAdmin) {

		doctor.setEsAdmin(esAdmin);

		doctorServicio.edit(doctor);
		return "redirect:/admin/mostrarDoctores";
	}

	// borrar doctor
	@GetMapping("/borrarDoctor/{id}")
	public String borrarDoctor(@PathVariable("id") Long id) {

		Optional<Doctor> optionalDoctor = doctorServicio.findById(id);

		if (optionalDoctor.isPresent()) {

			if (optionalDoctor.get().getCitas().isEmpty()) {
				doctorServicio.delete(optionalDoctor.get());
			} else {

				return "redirect:/admin/mostrarDoctores?error=true";
			}

		}

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

		if (usuarioServicio.encontrarPorUsername(cliente.getUsername())) {

			return "errorUsername";
		}

		usuarioServicio.codificarContrasenya(cliente.getPassword(), cliente);

		usuarioServicio.save(cliente);

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

		if (borrarCliente.isPresent()) {

			if (borrarCliente.get().getCitas().isEmpty()) {
				clienteServicio.delete(borrarCliente.get());
			} else {

				return "redirect:/admin/mostrarClientes?error=true";
			}

		}

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

	// borrar seguro
	@GetMapping("/borrarSeguro/{id}")
	public String borrarSeguro(@PathVariable("id") Long id) {

		Optional<Seguro> borrarSeguro = seguroServicio.findById(id);

		seguroServicio.delete(borrarSeguro.get());

		return "redirect:/admin/mostrarSeguros";
	}

	@GetMapping("/mostrarDepartamentos")
	public String departamentos(Model model) {
		model.addAttribute("departamentos", departamentoServicio.findAll());
		return "admin/tablaDepartamentos";
	}

	// formulario departamento
	@GetMapping("/nuevoDepartamento")
	public String mostrarFormularioDepartamentos(Model model) {

		model.addAttribute("departamento", new Departamento());

		return "admin/formularioDepartamento";
	}

	// insertar departamento
	@PostMapping("/nuevoDepartamento/submit")
	public String nuevoDepartamento(@ModelAttribute("departamento") Departamento departamento) {

		departamentoServicio.save(departamento);

		return "redirect:/admin/mostrarDepartamentos";
	}

	// formulario para editar departamento
	@GetMapping("/editarDepartamento/{id}")
	public String mostrarFormularioEdicionDepartamento(@PathVariable("id") Long id, Model model) {

		Optional<Departamento> editarDepartamento = departamentoServicio.findById(id);

		model.addAttribute("departamento", editarDepartamento.get());

		return "admin/formularioDepartamento";
	}

	// confirmar edicion departamento
	@PostMapping("/editarDepartamento/submit")
	public String procesarFormularioEdicionDepartamento(@ModelAttribute("departamento") Departamento departamento) {
		departamentoServicio.edit(departamento);
		return "redirect:/admin/mostrarDepartamentos";
	}

	// borrar departamento
	@GetMapping("/borrarDepartamento/{id}")
	public String borrarDepartamento(@PathVariable("id") Long id) {

		Optional<Departamento> borrarDepartamento = departamentoServicio.findById(id);

		departamentoServicio.delete(borrarDepartamento.get());

		return "redirect:/admin/mostrarDepartamentos";
	}

	// mostrar tabla citas
	@GetMapping("/mostrarCitas")
	public String citas(Model model) {
		model.addAttribute("citas", citaServicio.findAll());
		return "admin/tablaCitas";
	}

	// formulario cita
	@GetMapping("/nuevaCita")
	public String mostrarFormularioCitas(Model model) {

		List<Doctor> doctores = doctorServicio.findAll();
		model.addAttribute("doctores", doctores);

		List<Cliente> clientes = clienteServicio.findAll();
		model.addAttribute("clientes", clientes);

		model.addAttribute("cita", new Cita());

		return "admin/formularioCitas";
	}

	// insertar cita
	@PostMapping("/nuevaCita/submit")
	public String nuevaCita(@ModelAttribute("cita") Cita cita) {

		citaServicio.save(cita);

		return "redirect:/admin/mostrarCitas";
	}

	// formulario para editar Cita
	@GetMapping("/editarCita/{id_doctor}/{id_cliente}/{fecha_inicio}")
	public String mostrarFormularioEdicionCita(@PathVariable("id_doctor") long id_doctor,
			@PathVariable("id_cliente") long id_cliente, @PathVariable("fecha_inicio") LocalDateTime fecha_inicio,
			Model model) {

		CitasPk citaId = new CitasPk(id_doctor, id_cliente, fecha_inicio);

		Optional<Cita> editarCita = citaServicio.findById(citaId);

		model.addAttribute("cita", editarCita.get());

		return "admin/formularioCitas";

	}

	// confirmar edicion cita
	@PostMapping("/editarCita/submit")
	public String procesarFormularioEdicionCita(@ModelAttribute("cita") Cita cita) {

		citaServicio.edit(cita);

		return "redirect:/admin/mostrarCitas";
	}

	// borrar cita
	@GetMapping("/borrarCita/{id_doctor}/{id_cliente}/{fecha_inicio}")
	public String borrarCita(@PathVariable("id_doctor") long id_doctor, @PathVariable("id_cliente") long id_cliente,
			@PathVariable("fecha_inicio") LocalDateTime fecha_inicio) {

		CitasPk citaId = new CitasPk(id_doctor, id_cliente, fecha_inicio);

		Optional<Cita> borrarCita = citaServicio.findById(citaId);

		citaServicio.delete(borrarCita.get());

		return "redirect:/admin/mostrarCitas";
	}
}
