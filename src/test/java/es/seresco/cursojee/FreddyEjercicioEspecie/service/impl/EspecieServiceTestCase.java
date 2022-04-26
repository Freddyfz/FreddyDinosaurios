package es.seresco.cursojee.FreddyEjercicioEspecie.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class EspecieServiceTestCase extends AbstractServiceTestCase{

	@Autowired
	private EspecieService especieService;
	
	@Test
	@DisplayName("Obtener todas las familias de dinosaurios")
	public void testFindAll() throws MiValidationException {
		List<EspecieDto> resultado= especieService.findEspecies();
		assertNotNull(resultado);
		assertEquals("Se esperan 3 especies", 1, resultado.size());
	}
}
