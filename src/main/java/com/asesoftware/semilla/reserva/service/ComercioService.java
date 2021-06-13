package com.asesoftware.semilla.reserva.service;


import java.util.Optional;

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
	
	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper mapperComercio;

	@Override
	public ResponseDTO getAll() {
		return new ResponseDTO(mapperComercio.listEntitytoDto(comercioRepository.findAll()), true, "OK", HttpStatus.OK);
	}

	@Override
	public ResponseDTO getComercioById(Integer id) {
		
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		if(optional.isPresent()) {
			return new ResponseDTO(optional.get(), true, "OK", HttpStatus.OK);
		}
		return new ResponseDTO(null, false, "Comercio No Encontrado", HttpStatus.OK);

	}

	@Override
	public ResponseDTO createComercio(ComercioDTO comercioDTO) {
		try {
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			comercioRepository.save(comercioEntity);
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "Comercio Creado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede crear el Comercio", HttpStatus.OK);
		}
		
		
	}

	@Override
	public ResponseDTO updateComercio(ComercioDTO comercioDTO) {
		try {
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			comercioRepository.save(comercioEntity);
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "Comercio Editado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede editar el Comercio", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO deleteComercio(Integer id) {
		try {
			comercioRepository.deleteById(id);
			return new ResponseDTO(null, true, "Comercio Eliminado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede eliminar el servicio", HttpStatus.OK);
		}
	}

	


}
