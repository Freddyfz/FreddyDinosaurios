package es.seresco.cursojee.FreddyEjercicioEspecie.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewRecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.RecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Recinto;

@Mapper(componentModel = "spring")
public interface RecintoMapper {

	@Mapping(source="codigo",target="codigo")
	@Mapping(source="descripcion",target="descripcion")
	@Mapping(source="idTipoAlimentacion",target="tipoAlimentacion.id")
	@Mapping(source="animales",target="animales")
	public Recinto newRecintoDtoToRecinto(NewRecintoDto newRecintoDto);
	
	@InheritInverseConfiguration
	public NewRecintoDto recintoTonewRecintoDto(Recinto recinto);
	
	@Mapping(source="id",target="id")
	@Mapping(source="codigo",target="codigo")
	@Mapping(source="descripcion",target="descripcion")
	public Recinto recintoDtoToRecinto(RecintoDto recintoDto);
	
	@InheritInverseConfiguration
	public RecintoDto recintoToRecintoDto(Recinto recinto);

	public List<RecintoDto> recintoTomapRecintoDtoList(List<Recinto> recintos);
}
