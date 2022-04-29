package es.seresco.cursojee.FreddyEjercicioEspecie.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacion;

@Mapper(componentModel = "spring")
public interface EspecieTipoAlimentacionMapper {

	@Mapping(source="idEspecie",target="idEspecie")
	@Mapping(source="idTipoAlimentacion",target="idTipoAlimentacion")
	public EspecieTipoAlimentacion especieTipoAlimentacionDtoToEspecieTipoAlimentacion(EspecieTipoAlimentacionDto especieTipoAlimentacionDto);
	
	@InheritInverseConfiguration
	public EspecieTipoAlimentacionDto especieTipoAlimentacionToEspecieTipoAlimentacionDto(EspecieTipoAlimentacion especieTipoAlimentacion);

	public List<EspecieTipoAlimentacionDto> especieTipoAlimentacionTomapEspecieDtoList(List<EspecieTipoAlimentacion> especieTipoAlimentacions);
}