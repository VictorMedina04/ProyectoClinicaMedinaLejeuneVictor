package com.salesianostriana.dam.clinicamedinalejeunevictor.controladores;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.salesianostriana.dam.clinicamedinalejeunevictor.exceptions.DoctorNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(DoctorNotFoundException.class)
	public ModelAndView handleDoctorNotFoundException(DoctorNotFoundException exception) {

		ModelAndView modelView = new ModelAndView();
		modelView.addObject("message", exception.getMessage());
		modelView.setViewName("emptyList");
		return modelView;
	}
}
