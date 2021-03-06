package es.seresco.cursojee.FreddyEjercicioEspecie.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.FamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewFamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Familia;

@Mapper(componentModel = "spring")
public interface FamiliaMapper {

	@Mapping(source="nombre",target="nombre")
	public Familia newFamiliaDtoToFamilia(NewFamiliaDto newFamiliaDto);
	
	@InheritInverseConfiguration
	public NewFamiliaDto familiaTonewFamiliaDto(Familia familia);
	
	@Mapping(source="id",target="id")
	@InheritConfiguration(name="newFamiliaDtoToFamilia")
	public Familia familiaDtoToFamilia(FamiliaDto familiaDto);
	
	@InheritInverseConfiguration
	public FamiliaDto familiaToFamiliaDto(Familia familia);

	public List<FamiliaDto> familiaTomapFamiliaDtoList(List<Familia> familias);
}
