package com.asesoftware.semilla.reserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asesoftware.semilla.reserva.entity.TurnoEntity;

public interface ITurnoRepository extends JpaRepository<TurnoEntity, Integer> {
	/*
	@Query(value = "SELECT t.id_turno, t.fecha_turno, t.hora_inicio, t.hora_fin, t.estado, t.id_servicios "
			+ " FROM Comercios c, Servicios s, Turnos t "
			+ "WHERE t.id_servicios = s.id_servicios and s.comercio_solicitante = c.id_comercio and t.id_servicios= ?1 and s.id_servicios = ?2", nativeQuery = true)
	List<TurnoEntity> getTurnoByComercioAndService(@Param("id_comercio") Integer id1, @Param("id_servicios") Integer id2);
	*/
	@Query(value = "SELECT t  "
			+ "FROM TurnoEntity t, ServicioEntity s, ComercioEntity c "
			+ "WHERE t.id_servicios = s.id and s.idComercio = c.id_comercio and c.id_comercio = ?1")
	List<TurnoEntity> getTurnoByComercio(@Param("id_comercio") Integer id);
	
	@Query(value = "SELECT t "
			+ "FROM TurnoEntity t, ServicioEntity s "
			+ "WHERE t.id_servicios = s.id and s.id = ?1")
	List<TurnoEntity> getTurnoByServicio(@Param("id_servicios") Integer id);
}
