package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.FamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewFamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Familia;

public interface FamiliaService {
	
	public static final String BEAN_NAME = "FamiliaServiceImpl";

	FamiliaDto getFamilia(Long idFamilia);
	
	FamiliaDto create(NewFamiliaDto newFamilia);
	
	List<FamiliaDto> findFamilias () throws MiValidationException;
	
	FamiliaDto updateFamilia(Long idFamilia, NewFamiliaDto updatedFamilia) throws MiValidationException;

	FamiliaDto updateFamilia(FamiliaDto updatedFamilia) throws MiValidationException;

	void deleteFamilia(Long idFamilia);

	Familia getFamiliaObj(Long idFamilia);

	Familia updateFamiliaObj(FamiliaDto updatedFamilia);

	Familia updateFamiliaObj(Long idFamilia, NewFamiliaDto updatedFamilia);
}
