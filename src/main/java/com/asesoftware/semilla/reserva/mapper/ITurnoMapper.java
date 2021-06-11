package com.asesoftware.semilla.reserva.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.asesoftware.semilla.reserva.dto.TurnoDTO;
import com.asesoftware.semilla.reserva.entity.TurnoEntity;

@Mapper(componentModel = "spring")
public interface ITurnoMapper {
	
	@Mappings({@Mapping(source= "id", target = "idTurno"),
				@Mapping(source= "fecha", target = "fechaTurno"),
				@Mapping(source= "hora_inicio", target = "horaInicio"),
				@Mapping(source= "hora_fin", target = "horaFin")
	
	})
	public TurnoDTO entityToDto(TurnoEntity turnoEntity);
	
	@Mappings({@Mapping(source = "idTurno", target = "id"),
		@Mapping(source = "fechaTurno", target = "fecha"),
		@Mapping(source= "horaInicio", target = "hora_inicio"),
		@Mapping(source= "horaFin", target = "hora_fin")
		
	
	})
	public TurnoEntity dtoToEntity(TurnoDTO turnoDTO);
	
	public List<TurnoDTO> listEntityToDto(List<TurnoEntity> turnoEntity);
	
	public List<TurnoEntity> listDtoToEntity(List<TurnoDTO> turnoDTO);
	
}
