package com.asesoftware.semilla.reserva.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.semilla.reserva.dto.ServicioDTO;
import com.asesoftware.semilla.reserva.entity.ServicioEntity;


@Mapper(componentModel = "spring")
public interface IServicioMapper {
	@Mappings({@Mapping(source = "id", target = "idServicio")})
	
	public ServicioDTO entityToDto(ServicioEntity servicioEntity);
	
	@Mappings({@Mapping(source = "idServicio", target = "id")})
	public ServicioEntity dtoToEntity(ServicioDTO servicioDTO);
	
	public List<ServicioDTO> listEntitytoDto(List<ServicioEntity> servicioEntity);
	
	public List<ServicioEntity> listDtoToEntity(List<ServicioDTO> servicioDTO);

}
