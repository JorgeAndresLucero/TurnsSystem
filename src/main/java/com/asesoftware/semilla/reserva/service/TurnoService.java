package com.asesoftware.semilla.reserva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.reserva.dto.TurnoDTO;
import com.asesoftware.semilla.reserva.entity.TurnoEntity;
import com.asesoftware.semilla.reserva.mapper.ITurnoMapper;
import com.asesoftware.semilla.reserva.repository.ITurnoRepository;
@Service
public class TurnoService implements ITurnoService {
	@Autowired
	private ITurnoRepository turnoRepository;

	@Autowired
	public ITurnoMapper mapperTurno;
	/*
	@Override
	
	public List<TurnoEntity> getAll() {
		return turnoRepository.findAll();
	}

	@Override
	public List<TurnoEntity> getTurnoByComercioAndService(Integer id1,  Integer id2) {	
		return  turnoRepository.getTurnoByComercioAndService(id1, id2);
	}
	
	@Override
	public List<TurnoEntity> getTurnoByComercio(Integer id) {
		return turnoRepository.getTurnoByComercio(id);
	}

	@Override
	public List<TurnoEntity> getTurnoByServicio(Integer id) {
		return turnoRepository.getTurnoByServicio(id);
	}
	

	@Override
	public TurnoEntity getOneById(Integer id) {
		Optional<TurnoEntity> optional = turnoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;

	}
	
	@Override
	public TurnoEntity createTurno(TurnoEntity turnoEntity) {
		try {
			return turnoRepository.save(turnoEntity);
		} catch (Exception e) {
			return null;
		}
	}
		

	@Override
	public TurnoEntity updateTurno(TurnoEntity turnoEntity) {
		try {
			return turnoRepository.save(turnoEntity);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteTurnoById(Integer id) {
		turnoRepository.deleteById(id);
		
	}

	@Override
	public TurnoDTO buscarPorId(Integer id) {
		Optional<TurnoEntity> turnoEntity = turnoRepository.findById(id);
		return mapperTurno.entityToDto(turnoEntity.get());
	}
	*/
	@Override
	public List<TurnoDTO> getTurnoByComercios(Integer id) {
	
		return mapperTurno.listEntityToDto(turnoRepository.getTurnoByComercio(id));
		
	}

	@Override
	public List<TurnoDTO> getTurnoByServicios(Integer id) {

		return mapperTurno.listEntityToDto(turnoRepository.getTurnoByServicio(id));
	}
	
	

	
	

}
