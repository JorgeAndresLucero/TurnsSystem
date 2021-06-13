package com.asesoftware.semilla.reserva.dto;

import java.util.List;


import lombok.Data;

@Data
public class ComercioDTO {
	

	private Integer id_comercio;
	

	private String nombre_comercio;
	

	private Integer aforo_max;
	

	private List<ServicioDTO> servicios;
}
