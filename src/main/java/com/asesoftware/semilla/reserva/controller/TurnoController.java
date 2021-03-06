package com.asesoftware.semilla.reserva.controller;



import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.semilla.reserva.dto.ResponseDTO;
import com.asesoftware.semilla.reserva.service.ITurnoService;

@RestController
@RequestMapping(path = "/api/v1/turno")

public class TurnoController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TurnoController.class);
	@Autowired
	private ITurnoService turnoService;

	/*
	@GetMapping(path = "/all")
	// listar todos
	public List<TurnoEntity> getAll() {
		return turnoService.getAll();
	}

	// listar uno
	@GetMapping(path = "/turno/{id}")
	public TurnoEntity getTurnoById(@PathVariable Integer id) {
		return turnoService.getOneById(id);
	}

	// listar uno mapper
	@GetMapping(path = "/turnos/{id}")
	public TurnoDTO buscarPorId(@PathVariable Integer id) {
		return turnoService.buscarPorId(id);
	}

	// listar por comercio y servicio
	@GetMapping(path = "/turno/comercio/{id1}/servicio/{id2}")
	public List<TurnoEntity> getTurnoByComercioAndServicio(@PathVariable Integer id1, @PathVariable Integer id2) {
		return turnoService.getTurnoByComercioAndService(id1, id2);

	}

	// listar por comercio
	@GetMapping(path = "/turno/comercio/{id}")
	public List<TurnoEntity> getTurnoByComercio(@PathVariable Integer id) {
		return turnoService.getTurnoByComercio(id);

	}

	// listar por servicio
	@GetMapping(path = "/turno/servicio/{id}")
	public List<TurnoEntity> getTurnoByServicio(@PathVariable Integer id) {
		return turnoService.getTurnoByServicio(id);
	}

	// crear
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public TurnoEntity createComercio(@RequestBody TurnoEntity servicioEntity) {
		try {
			return turnoService.createTurno(servicioEntity);
		} catch (Exception e) {
			return null;
		}

	}

	// editar
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public TurnoEntity updateTurno(@RequestBody TurnoEntity turnoEntity) {
		try {
			return turnoService.updateTurno(turnoEntity);
		} catch (Exception e) {
			return null;
		}

	}

	// eliminar
	@GetMapping(path = "delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		turnoService.deleteTurnoById(id);
	}
	*/
	// listar por comercio mapper
	@GetMapping(path = "/turno/comercios/{id}")
	public ResponseDTO getTurnoByComercios(@PathVariable Integer id) {
		logger.info("Ingreso al m??todo getTurnoByComercios ");
		
		logger.info("Se listar?? un turno por el comercio: {}",id);
		return turnoService.getTurnoByComercios(id);

	}

	// listar por servicio mapper
	@GetMapping(path = "/turno/servicios/{id}")
	public ResponseDTO getTurnoByServicios(@PathVariable Integer id) {
		logger.info("Ingreso al m??todo getTurnoByServicios ");
		
		logger.info("Se listar?? un turno por el servicio: {}",id);
		return turnoService.getTurnoByServicios(id);
	}
}
