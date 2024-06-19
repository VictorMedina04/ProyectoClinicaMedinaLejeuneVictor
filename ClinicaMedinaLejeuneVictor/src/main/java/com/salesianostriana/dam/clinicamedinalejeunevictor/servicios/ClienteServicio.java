
package com.salesianostriana.dam.clinicamedinalejeunevictor.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cliente;
import com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios.ClienteRepositorio;
import com.salesianostriana.dam.clinicamedinalejeunevictor.servicios.serviciosbase.BaseServiceImpl;

@Service
public class ClienteServicio extends BaseServiceImpl<Cliente, Long, ClienteRepositorio> {

	@Autowired
	private CitaServicio citaServicio;

	public void borrarCitaCliente(Cliente cliente, Cita cita) {

		cliente.getCitas().remove(cita);

	}
	
	public int contarCitasCliente(Cliente cliente) {
		
		return citaServicio.contarCitasCliente(cliente.getId());
		
	}
	
	
	public double hacerDescuentoPorSeguro(Cita cita) {

		Cliente cliente = cita.getCliente();
	    String seguro = cliente.getSeguro().getNombre().toLowerCase();
	  
	    	double nuevoPrecio = switch (seguro) {
	            
	    		case "sin seguro" -> cita.getPrecioCita();
	    	
	            case "seguro bronce" -> {
	                if (!cita.isEspecial()) {
	                    yield cita.getPrecioCita() - cita.getPrecioCita() * 10 / 100;
	                } else {
	                    yield cita.getPrecioCita();
	                }
	            }
	           
	            case "seguro plata" -> {
	            	
	            	if (cita.isEspecial()) {         	
	            		yield cita.getPrecioCita() - cita.getPrecioCita() * 15 / 100;	
	            	}
	            	else {
	            		yield 0;
	            	}
	            }
	            
	            case "seguro oro" -> 0.0;
	            
	            
	            case "seguro platino" -> {
	            
					List<Cita> citasPorDepartamento = citaServicio.buscarPorDepartamento(cita);
					
					for (Cita cita2 : citasPorDepartamento) {
						yield cita2.getPrecioCita() - cita2.getPrecioCita() * 45 / 100;
					
					}
					
					yield cita.getPrecioCita();
	            }
	            case "seguro paladio" -> {
	               yield nuevoPrecio = cita.getPrecioCita() - cita.getPrecioCita() * 50 / 100;
	            }
	           
	            default -> cita.getPrecioCita() - cita.getPrecioCita() * 10 / 100;
	        
	    	};
	      
	    	return nuevoPrecio;
	    }
}
