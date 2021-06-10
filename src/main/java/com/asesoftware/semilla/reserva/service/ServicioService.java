package com.asesoftware.semilla.reserva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.asesoftware.semilla.reserva.entity.ServicioEntity;
import com.asesoftware.semilla.reserva.repository.IServicioRepository;
@Service
public class ServicioService implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	@GetMapping(path ="comercio/{id}")
	public List<ServicioEntity> getAll() {
		
		return servicioRepository.findAll();
	}

	@Override
	public ServicioEntity getOneById(Integer id) {
		Optional<ServicioEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public ServicioEntity createServicio(ServicioEntity servicioEntity) {
		try {
			return servicioRepository.save(servicioEntity);
		} catch (Exception e) {
			return null;
		}
	}
		

	@Override
	public ServicioEntity updateServicio(ServicioEntity servicioEntity) {
		try {
			return servicioRepository.save(servicioEntity);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public void deleteServicioById(Integer id) {
		servicioRepository.deleteById(id);		
	}

}
