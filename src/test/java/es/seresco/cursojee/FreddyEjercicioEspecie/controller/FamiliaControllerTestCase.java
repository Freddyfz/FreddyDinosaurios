package es.seresco.cursojee.FreddyEjercicioEspecie.controller;

import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.FamiliaService;

@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class FamiliaControllerTestCase {
	
	@MockBean
	private FamiliaService familiaService;
	
	@Test
	@DisplayName("Obtener familia por id")
	public void testGetId() throws Exception{
		
	}
}
