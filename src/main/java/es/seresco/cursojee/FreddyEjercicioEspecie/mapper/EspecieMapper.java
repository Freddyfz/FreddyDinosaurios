package es.seresco.cursojee.FreddyEjercicioEspecie.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Especie;

@Mapper(componentModel = "spring")
public interface EspecieMapper {

	@Mapping(source="idFamilia",target="familia.id")
	@Mapping(source="nombre",target="nombre")
	@Mapping(source="codigoTipoPeligrosidad",target="codigoTipoPeligrosidad")
	@Mapping(source="longitud",target="longitud")
	@Mapping(source="anioDesde",target="anioDesde")
	@Mapping(source="anioHasta",target="anioHasta")
	public Especie newEspecieDtoToEspecie(NewEspecieDto newEspecieDto);
	
	@InheritInverseConfiguration
	public NewEspecieDto especieTonewEspecieDto(Especie especie);
	
	@Mapping(source="id",target="id")
	@InheritConfiguration(name="newEspecieDtoToEspecie")
	public Especie especieDtoToEspecie(EspecieDto especieDto);
	
	@InheritInverseConfiguration
	public EspecieDto especieToEspecieDto(Especie especie);

	public List<EspecieDto> especieTomapEspecieDtoList(List<Especie> especies);
}
