package com.asesoftware.semilla.reserva.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
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
	
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_apertura")
	private Date fecha_ini;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_cierre")
	private Date fecha_fin;
	
	
	@Column(name = "duracion")
	private Integer duracion;
	
	@Column(name = "id_comercio")
	private Integer idComercio;
	
	@OneToMany(mappedBy="id_servicios")
	private List<TurnoEntity> turnos;
	
	
}
