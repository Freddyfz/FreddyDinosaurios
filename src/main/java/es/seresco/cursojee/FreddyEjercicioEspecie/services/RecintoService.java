package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewRecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.RecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Recinto;

public interface RecintoService {

	public static final String BEAN_NAME = "recintoService";

	RecintoDto getRecinto(Long idRecinto);
	
	RecintoDto create(NewRecintoDto newRecinto);
	
	List<RecintoDto> findRecintos () throws MiValidationException;
	
	RecintoDto updateRecinto(Long idRecinto, NewRecintoDto updatedRecinto) throws MiValidationException;

	RecintoDto updateRecinto(RecintoDto updatedRecinto) throws MiValidationException;

	Recinto deleteRecinto(Long idRecinto) throws MiValidationException;

	Recinto getRecintoObj(Long idRecinto);
}
