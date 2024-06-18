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

	// citas que su duracion sea 15
	@Query("""
			SELECT c
			FROM Cita c
			WHERE duracion = 15
			""")
	List<Cita> findByDuracionMenor(int duracion);

	// citas que su duracion sea 60
	@Query("""
			SELECT c
			FROM Cita c
			WHERE duracion = 60
			""")
	List<Cita> findByDuracionMayor(int duracion);

	// contar las citas de un doctor
	@Query("""
			SELECT count(c)
			FROM Cita c
			WHERE c.doctor.id = ?1
			""")
	int countByDoctor(Long id);
}
