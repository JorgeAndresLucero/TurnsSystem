package com.asesoftware.semilla.reserva.controller;



import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.reserva.dto.ComercioDTO;
import com.asesoftware.semilla.reserva.dto.ResponseDTO;
import com.asesoftware.semilla.reserva.service.IComercioService;


@RestController
@RequestMapping(path ="/api/v1/comercio")

public class ComercioController {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ComercioController.class);
	@Autowired
	private IComercioService comercioService;
	
	@GetMapping(path = "/all")
	//listar todos
	public ResponseDTO getAll(){
		logger.info("Ingreso al metodo getAll ");
		return comercioService.getAll();
	}
	// listar uno 
		@GetMapping(path ="/comercio/{id}")
		public ResponseDTO getComercioById(@PathVariable Integer id) {
			logger.info("Ingreso al metodo listar por id ");
			
			logger.info("Comercio a mostrar {}",id);
		return comercioService.getComercioById(id);
		}
		
	//crear	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO createComercio (@RequestBody ComercioDTO comercioEntity ){
		logger.info("Ingreso al metodo updateComercio ");
		
		logger.info("Comercio a editar: {}", comercioEntity.getId_comercio());
		return comercioService.createComercio(comercioEntity);
	
		
	}
	// editar
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateComercio(@RequestBody ComercioDTO comercioEntity){
		logger.info("Ingreso al metodo updateComercio ");
	
		logger.info("Comercio a editar: {}", comercioEntity.getId_comercio());
		
		return comercioService.updateComercio(comercioEntity);
	}
	//eliminar
	@GetMapping(path ="delete/{id}")
	public ResponseDTO deleteById(@PathVariable Integer id){
		logger.info("Ingreso al metodo eliminarComercio ");
		
		logger.info("Comercio a eliminar {}",id);
		return comercioService.deleteComercio(id);
	}

}
