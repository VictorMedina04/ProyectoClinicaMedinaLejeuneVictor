package com.salesianostriana.dam.clinicamedinalejeunevictor.repositorios;

import java.time.LocalDateTime;
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

	@Query("""
			SELECT count(c)
			FROM Cita c
			WHERE (c.citasPk.id_cliente = ?1
			AND c.citasPk.fecha_inicio = ?2)
			OR (c.citasPk.id_doctor = ?3
			AND c.citasPk.fecha_inicio = ?2)
			""")
	int existeCita(long id_cliente, LocalDateTime fecha, long id_doctor);
	
	
	
}
