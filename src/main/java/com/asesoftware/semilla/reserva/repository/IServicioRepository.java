package com.asesoftware.semilla.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.semilla.reserva.entity.ServicioEntity;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {

}
