package com.asesoftware.semilla.reserva.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.semilla.reserva.entity.ComercioEntity;

public interface IComercioRepository extends JpaRepository<ComercioEntity, Integer> {

}
