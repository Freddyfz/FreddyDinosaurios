package es.seresco.cursojee.FreddyEjercicioEspecie.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Ejemplar;

@Mapper(componentModel = "spring")
public interface EjemplarMapper {

	@Mapping(source="idEspecie",target="especie.id")
	@Mapping(source="nombre",target="nombre")
	@Mapping(source="sexo",target="sexo")
	@Mapping(source="idRecinto",target="recinto.id")
	public Ejemplar newEjemplarDtoToEjemplar(NewEjemplarDto newEjemplarDto);
	
	@InheritInverseConfiguration
	public NewEjemplarDto ejemplarTonewEjemplarDto(Ejemplar ejemplar);
	
	@Mapping(source="id",target="id")
	@InheritConfiguration(name="newEjemplarDtoToEjemplar")
	public Ejemplar ejemplarDtoToEjemplar(EjemplarDto ejemplarDto);
	
	@InheritInverseConfiguration
	public EjemplarDto ejemplarToEjemplarDto(Ejemplar ejemplar);

	public List<EjemplarDto> ejemplarTomapEjemplarDtoList(List<Ejemplar> ejemplars);
}
