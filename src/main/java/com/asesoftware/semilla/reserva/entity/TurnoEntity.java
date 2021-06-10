package com.asesoftware.semilla.reserva.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="turnos")
public class TurnoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_turno")
	private Integer id;
	@Column(name="fecha_turno")
	private Date fecha;
	@Column(name="hora_inicio")
	private Time hora_inicio;
	@Column(name="hora_fin")
	private Time hora_fin;
	@Column(name="estado")
	private String estado;
	@Column(name="id_servicios")
	private Integer id_servicios;

}
