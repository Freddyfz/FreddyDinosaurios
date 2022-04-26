package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;

public interface EjemplarService {

	public static final String BEAN_NAME = "ejemplarService";

	EjemplarDto getEjemplar(Long idEjemplar);
	
	EjemplarDto create(NewEjemplarDto newEjemplar);
	
	List<EjemplarDto> findEjemplares () throws MiValidationException;
	
	EjemplarDto updateEjemplar(Long idEjemplar, NewEjemplarDto updatedEjemplar) throws MiValidationException;

	EjemplarDto updateEjemplar(EjemplarDto updatedEjemplar) throws MiValidationException;

	void deleteEjemplar(Long idEjemplar);
}
