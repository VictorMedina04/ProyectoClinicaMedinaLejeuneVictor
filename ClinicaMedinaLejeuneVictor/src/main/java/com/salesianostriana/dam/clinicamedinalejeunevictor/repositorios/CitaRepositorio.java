package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.Cita;
import com.salesianostriana.dam.clinicamedinalejeunevictor.modelos.CitasPk;

public interface CitaRepositorio extends JpaRepository<Cita, CitasPk> {

	// buscar las citas que pertenecen al departamento que le pase

	@Query("SELECT c FROM Cita	c JOIN c.doctor WHERE c.doctor.departamento.idDepartamento = ?1")
	List<Cita> findByDepartamento(Long idDepartamento);



	// contar las citas de un cliente
	@Query("""
			SELECT count(c)
			FROM Cita c
			WHERE c.cliente.id = ?1
			""")
	int countByCliente(Long id);

}
