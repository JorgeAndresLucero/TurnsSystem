    package com.asesoftware.semilla.reserva.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import lombok.Data;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Data
@Entity
@Table(name="comercios")
public class ComercioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comercio")
	private Integer id_comercio;
	
	@Column(name="nom_comercio")
	private String nombre_comercio;
	
	@Column(name="aforo_maximo")
	private Integer aforo_max;
	
	@OneToMany(mappedBy = "id")
	private List<ServicioEntity> servicios;

}
