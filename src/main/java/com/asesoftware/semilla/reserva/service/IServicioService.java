package com.asesoftware.semilla.reserva.service;

import java.util.List;

import com.asesoftware.semilla.reserva.entity.ServicioEntity;

public interface IServicioService {
	public List<ServicioEntity> getAll();
	public ServicioEntity getOneById(Integer id);
	public ServicioEntity createServicio(ServicioEntity servicioEntity);
	public ServicioEntity updateServicio(ServicioEntity servicioEntity);
	public void deleteServicioById(Integer id);
}
