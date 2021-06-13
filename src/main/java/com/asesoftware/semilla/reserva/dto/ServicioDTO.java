package com.asesoftware.semilla.reserva.dto;



import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ServicioDTO {
	
	private Integer idServicio;
	
	private String nombre_servicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/New_York")
	private Date fecha_ini;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/New_York")
	private Date fecha_fin;
	
	private Integer duracion;
	
	private Integer idComercio;
	
	private List<TurnoDTO> turnos;
	
	
	 
	
	
}
