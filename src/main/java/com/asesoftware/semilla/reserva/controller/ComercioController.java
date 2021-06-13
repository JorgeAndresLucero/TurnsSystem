package com.asesoftware.semilla.reserva.controller;


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
	@Autowired
	private IComercioService comercioService;
	
	@GetMapping(path = "/all")
	//listar todos
	public ResponseDTO getAll(){
		return comercioService.getAll();
	}
	// listar uno 
		@GetMapping(path ="/comercio/{id}")
		public ResponseDTO getComercioById(@PathVariable Integer id) {
		return comercioService.getComercioById(id);
		}
		
	//crear	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO createComercio (@RequestBody ComercioDTO comercioEntity ){
		try {
			return comercioService.createComercio(comercioEntity);
		} catch (Exception e) {
			return null;
		}
		
	}
	// editar
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateComercio(@RequestBody ComercioDTO comercioEntity){
		try {
			return comercioService.updateComercio(comercioEntity);
		} catch (Exception e) {
			return null;
		}
		
	}
	//eliminar
	@GetMapping(path ="delete/{id}")
	public ResponseDTO deleteById(@PathVariable Integer id){
		return comercioService.deleteComercio(id);
	}

}
