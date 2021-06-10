package com.asesoftware.semilla.reserva.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.sql.Time;
import java.util.List;
@Data
@Entity
@Table(name="servicios")
public class ServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicios")
	private Integer id;
	
	@Column(name= "nom_servicios")
	private String nombre_servicio;
	
	@Column(name = "hora_apertura")
	private Time fecha_ini;
	
	@Column(name = "hora_cierre")
	private Time fecha_fin;
	
	@Column(name = "duracion")
	private Integer duracion;
	
	@Column(name = "comercio_solicitante")
	private Integer comercioSolicitante;
	
	@OneToMany(mappedBy="id_servicios")
	private List<TurnoEntity> turnos;
	
	
}
