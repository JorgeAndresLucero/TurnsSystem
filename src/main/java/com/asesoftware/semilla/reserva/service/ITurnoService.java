package com.asesoftware.semilla.reserva.service;

import com.asesoftware.semilla.reserva.dto.ResponseDTO;


public interface ITurnoService {
	/*
	public List<TurnoEntity> getAll();
	public List<TurnoEntity> getTurnoByComercioAndService(Integer id1, Integer id2);
	public List<TurnoEntity> getTurnoByComercio(Integer id);
	public List<TurnoEntity> getTurnoByServicio(Integer id);
	public TurnoEntity getOneById(Integer id);
	public TurnoEntity createTurno(TurnoEntity turnoEntity);
	public TurnoEntity updateTurno(TurnoEntity turnoEntity);
	public void deleteTurnoById(Integer id);
	public TurnoDTO buscarPorId(Integer id);
	*/
	public ResponseDTO getTurnoByComercios(Integer id);
	public ResponseDTO getTurnoByServicios(Integer id);
}
