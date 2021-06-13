package com.asesoftware.semilla.reserva.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.reserva.dto.ResponseDTO;
import com.asesoftware.semilla.reserva.dto.ServicioDTO;
import com.asesoftware.semilla.reserva.service.IServicioService;

@RestController
@RequestMapping(path ="/api/v1/servicio")
public class ServicioController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ServicioController.class);
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping(path = "/all")
	//listar todos
	public ResponseDTO getAll(){
		return servicioService.getAll();
	}
	// listar uno 
		@GetMapping(path ="/servicio/{id}")
		public ResponseDTO getServicioById(@PathVariable Integer id) {
			logger.info("Ingreso al método getServiceById ");
			
			logger.info("Servicio a mostrar {}",id);
			return servicioService.getOneById(id);
		}
		
	//crear	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO createServicio(@RequestBody ServicioDTO servicioEntity ){
		logger.info("Ingreso al método updateComercio ");
			
		logger.info("Comercio a crear: {}", servicioEntity.getIdServicio());
	
		return servicioService.createServicio(servicioEntity);
			
	}
	// editar
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateServicio(@RequestBody ServicioDTO servicioEntity){
		logger.info("Ingreso al método updateComercio ");
		
		logger.info("Comercio a editar: {}", servicioEntity.getIdServicio());
			return servicioService.updateServicio(servicioEntity);

	}
	//eliminar
	@GetMapping(path ="delete/{id}")
	public ResponseDTO deleteServicioById(@PathVariable Integer id){
		logger.info("Ingreso al método eliminarServicio ");
		
		logger.info("Servicio a eliminar {}", id);
		return servicioService.deleteServicioById(id);
	}


}
