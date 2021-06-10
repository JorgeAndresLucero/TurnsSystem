package com.asesoftware.semilla.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.semilla.reserva.entity.ServicioEntity;
import com.asesoftware.semilla.reserva.service.IServicioService;

@RestController
@RequestMapping(path ="/api/v1/servicio")
public class ServicioController {
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping(path = "/all")
	//listar todos
	public List<ServicioEntity> getAll(){
		return servicioService.getAll();
	}
	// listar uno 
		@GetMapping(path ="/servicio/{id}")
		public ServicioEntity getComercioById(@PathVariable Integer id) {
		return servicioService.getOneById(id);
		}
		
	//crear	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ServicioEntity createComercio (@RequestBody ServicioEntity servicioEntity ){
		try {
			return servicioService.createServicio(servicioEntity);
		} catch (Exception e) {
			return null;
		}
		
	}
	// editar
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ServicioEntity updateServicio(@RequestBody ServicioEntity servicioEntity){
		try {
			return servicioService.updateServicio(servicioEntity);
		} catch (Exception e) {
			return null;
		}
		
	}
	//eliminar
	@GetMapping(path ="delete/{id}")
	public void deleteById(@PathVariable Integer id){
		servicioService.deleteServicioById(id);
	}


}
