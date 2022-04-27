package es.seresco.cursojee.FreddyEjercicioEspecie.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EjemplarService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class EjemplarServiceTestCase extends AbstractServiceTestCase{

	@Autowired
	private EjemplarService ejemplarService;
	
	@Test
	@DisplayName("Crear ejemplar con recinto lleno")
	public void testCreateLleno()throws MiValidationException{
		NewEjemplarDto newEjemplarDto=new NewEjemplarDto();
		newEjemplarDto.setNombre("Juanjo");
		newEjemplarDto.setIdRecinto(1L);
		newEjemplarDto.setIdEspecie(2L);
		newEjemplarDto.setSexo("MACHO");
		assertNull(ejemplarService.createObj(newEjemplarDto));
	}
	
	@Test
	@DisplayName("Crear ejemplar con recinto disponible")
	public void testCreateDisp()throws MiValidationException{
		NewEjemplarDto newEjemplarDto=new NewEjemplarDto();
		newEjemplarDto.setNombre("Juanjo");
		newEjemplarDto.setIdRecinto(6L);
		newEjemplarDto.setIdEspecie(2L);
		newEjemplarDto.setSexo("MACHO");
		assertNotNull(ejemplarService.createObj(newEjemplarDto));
	}
}
