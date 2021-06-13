package com.asesoftware.semilla.reserva.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.asesoftware.semilla.reserva.dto.ComercioDTO;
import com.asesoftware.semilla.reserva.dto.ResponseDTO;
import com.asesoftware.semilla.reserva.entity.ComercioEntity;
import com.asesoftware.semilla.reserva.mapper.IComercioMapper;
import com.asesoftware.semilla.reserva.repository.IComercioRepository;

@Service
public class ComercioService implements IComercioService{
	private static final Logger logger  = LoggerFactory.getLogger(ComercioService.class);
	
	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper mapperComercio;

	@Override
	public ResponseDTO getAll() {
		logger.info("Ingresó al método getAll");
		return new ResponseDTO(mapperComercio.listEntitytoDto(comercioRepository.findAll()), true, "OK", HttpStatus.OK);
	}

	@Override
	public ResponseDTO getComercioById(Integer id) {
		logger.info("Ingresó al método getComercioById");
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		if(optional.isPresent()) {
			logger.info("Se listó el Comercio {}",id);
			return new ResponseDTO(optional.get(), true, "OK", HttpStatus.OK);
		}
		return new ResponseDTO(null, false, "Comercio No Encontrado", HttpStatus.OK);

	}

	@Override
	public ResponseDTO createComercio(ComercioDTO comercioDTO) {
		
		logger.info("Ingresó al método createComercio");
		try {
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			comercioRepository.save(comercioEntity);
		logger.info("Se creó el comercio {}",comercioDTO.getId_comercio());
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "Comercio Creado", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede crear el Comercio", HttpStatus.OK);
		}
		
		
	}

	@Override
	public ResponseDTO updateComercio(ComercioDTO comercioDTO) {
			logger.info("Ingresó al método updateComercio");
		try {
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			comercioRepository.save(comercioEntity);
			logger.info("Se actualizó el comercio: {}",comercioDTO.getId_comercio());
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "Comercio Editado", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error: {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede editar el Comercio", HttpStatus.OK);
			
		}
		
	}

	@Override
	public ResponseDTO deleteComercio(Integer id) {
		logger.info("Ingresó al método deleteComercio");
		try {
			comercioRepository.deleteById(id);
			logger.info("El comercio {} se eliminó");
			return new ResponseDTO(null, true, "Comercio Eliminado", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			
			return new ResponseDTO(null, false, "No se puede eliminar el servicio", HttpStatus.OK);
		}
	}

	


}
