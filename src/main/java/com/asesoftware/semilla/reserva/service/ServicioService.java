package com.asesoftware.semilla.reserva.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.asesoftware.semilla.reserva.dto.ResponseDTO;
import com.asesoftware.semilla.reserva.dto.ServicioDTO;
import com.asesoftware.semilla.reserva.entity.ServicioEntity;
import com.asesoftware.semilla.reserva.mapper.IServicioMapper;
import com.asesoftware.semilla.reserva.repository.IServicioRepository;
@Service
public class ServicioService implements IServicioService {
	private static final Logger logger  = LoggerFactory.getLogger(ServicioService.class);
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private IServicioMapper mapperServicio;
	
	
	
	@Override
	public ResponseDTO getAll() {
		logger.info("Se ingreso al método getAll ");
		return new ResponseDTO(mapperServicio.listEntitytoDto(servicioRepository.findAll()), true, "ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO getOneById(Integer id) {
		logger.info("Se ingreso al metodo getOneById ");
		Optional<ServicioEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			logger.info("Se obtuvo el servicio {}",id);
			return new ResponseDTO(mapperServicio.entityToDto(optional.get()), true, "ok", HttpStatus.OK);
		}
		logger.error("No se pudo obtener el servicio {}",id);
		return new ResponseDTO(null, false, "Servicio No Encontrado", HttpStatus.OK);
	}

	@Override
	public ResponseDTO createServicio(ServicioDTO servicioDTO) {
		logger.info("Se ingreso al método createServicio ");
		try {
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDTO);
			servicioRepository.save(servicioEntity);
			logger.info("Se creó el servicio {}",servicioDTO.getIdServicio());
			return new ResponseDTO(mapperServicio.entityToDto(servicioEntity), true, "ok", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error: {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede crear el servicio", HttpStatus.OK);
		}
	}
		

	@Override
	public ResponseDTO updateServicio(ServicioDTO servicioDTO) {
		logger.info("Se ingreso al método updateServicio ");
		try {
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDTO);
			servicioRepository.save(servicioEntity);
			logger.info("Se actualizo el servicio {}",servicioDTO.getIdServicio());
			return new ResponseDTO(mapperServicio.entityToDto(servicioEntity), true, "ok", HttpStatus.OK);
	
		} catch (Exception e) {
			logger.error("Error: {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede actualizar el servicio", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO deleteServicioById(Integer id) {
		logger.info("Se ingreso al método deleteeServicioById");
		try {
			servicioRepository.deleteById(id);
			logger.info("Se elimino el servicio: {}",id);
			return new ResponseDTO(null, true, "ok", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error: {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede eliminar el servicio", HttpStatus.OK);
		}
				
	}

	
}
