package es.seresco.cursojee.FreddyEjercicioEspecie.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.TipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.TipoAlimentacion;

@Mapper(componentModel = "spring")
public interface TipoAlimentacionMapper {

	@Mapping(source="descripcion",target="descripcion")
	public TipoAlimentacion newTipoAlimentacionDtoToTipoAlimentacion(NewTipoAlimentacionDto newTipoAlimentacionDto);
	
	@InheritInverseConfiguration
	public NewTipoAlimentacionDto tipoAlimentacionTonewTipoAlimentacionDto(TipoAlimentacion tipoAlimentacion);
	
	@Mapping(source="id",target="id")
	@InheritConfiguration(name="newTipoAlimentacionDtoToTipoAlimentacion")
	public TipoAlimentacion tipoAlimentacionDtoToTipoAlimentacion(TipoAlimentacionDto tipoAlimentacionDto);
	
	@InheritInverseConfiguration
	public TipoAlimentacionDto tipoAlimentacionToTipoAlimentacionDto(TipoAlimentacion tipoAlimentacion);

	public List<TipoAlimentacionDto> tipoAlimentacionTomapTipoAlimentacionDtoList(List<TipoAlimentacion> tipoAlimentacions);
}
