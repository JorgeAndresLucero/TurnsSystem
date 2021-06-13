package com.asesoftware.semilla.reserva.service;


import java.util.Optional;

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
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private IServicioMapper mapperServicio;
	
	
	
	@Override
	public ResponseDTO getAll() {
		return new ResponseDTO(mapperServicio.listEntitytoDto(servicioRepository.findAll()), true, "ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO getOneById(Integer id) {
		Optional<ServicioEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}
		return new ResponseDTO(null, false, "Servicio No Encontrado", HttpStatus.OK);
	}

	@Override
	public ResponseDTO createServicio(ServicioDTO servicioDTO) {
		try {
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDTO);
			servicioRepository.save(servicioEntity);
			return new ResponseDTO(mapperServicio.entityToDto(servicioEntity), true, "ok", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede crear el servicio", HttpStatus.OK);
		}
	}
		

	@Override
	public ResponseDTO updateServicio(ServicioDTO servicioDTO) {
		try {
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDTO);
			servicioRepository.save(servicioEntity);
			return new ResponseDTO(mapperServicio.entityToDto(servicioEntity), true, "ok", HttpStatus.OK);
	
		} catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede actualizar el servicio", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO deleteServicioById(Integer id) {
		try {
			servicioRepository.deleteById(id);
			return new ResponseDTO(null, true, "ok", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede eliminar el servicio", HttpStatus.OK);
		}
				
	}

	
}
