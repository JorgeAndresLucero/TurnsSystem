package com.asesoftware.semilla.reserva.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import com.asesoftware.semilla.reserva.dto.ComercioDTO;
import com.asesoftware.semilla.reserva.entity.ComercioEntity;


@Mapper(componentModel = "spring", uses = {IServicioMapper.class} )
public interface IComercioMapper {
	
	public ComercioDTO entityToDto(ComercioEntity comercioEntity);
	
	public ComercioEntity dtoToEntity(ComercioDTO comercioDTO);
	
	public List<ComercioDTO> listEntitytoDto(List<ComercioEntity> comercioEntity);
	
	public List<ComercioEntity> listDtoToEntity(List<ComercioDTO> comercioDTO);

}
