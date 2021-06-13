package com.asesoftware.semilla.reserva.service;



import com.asesoftware.semilla.reserva.dto.ResponseDTO;
import com.asesoftware.semilla.reserva.dto.ServicioDTO;


public interface IServicioService {
	public ResponseDTO getAll();
	
	public ResponseDTO getOneById(Integer id);
	
	public ResponseDTO createServicio(ServicioDTO servicioDTO);
	
	public ResponseDTO updateServicio(ServicioDTO servicioDTO);
	
	public ResponseDTO deleteServicioById(Integer id);
}
