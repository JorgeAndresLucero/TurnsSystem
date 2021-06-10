package com.asesoftware.semilla.reserva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.asesoftware.semilla.reserva.entity.ComercioEntity;
import com.asesoftware.semilla.reserva.repository.IComercioRepository;

@Service
public class ComercioService implements IComercioService{
	
	@Autowired
	private IComercioRepository comercioRepository;

	@Override

	public List<ComercioEntity> getAll() {
	
		return comercioRepository.findAll();
	}

	@Override
	@GetMapping(path ="comercio/{id}")
	public ComercioEntity getComercioById(Integer id) {
		
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	@Override
	public ComercioEntity createComercio(ComercioEntity comercioEntity) {
		try {
			return comercioRepository.save(comercioEntity);
		} catch (Exception e) {
			return null;
		}
		
		
	}

	@Override
	public ComercioEntity updateComercio(ComercioEntity comercioEntity) {
		try {
			return comercioRepository.save(comercioEntity);
		} catch (Exception e) {
			return null;
		}
		
		
	}

	@Override
	public void deleteComercio(Integer id) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		comercioRepository.deleteById(id);
	}

}
