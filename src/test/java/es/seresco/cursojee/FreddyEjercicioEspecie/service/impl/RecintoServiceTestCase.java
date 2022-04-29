package es.seresco.cursojee.FreddyEjercicioEspecie.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewRecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.RecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.RecintoService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class RecintoServiceTestCase extends AbstractServiceTestCase{

	@Autowired
	private RecintoService recintoService;
	
	@Test
	@DisplayName("Obtener recinto")
	public void testGet()throws MiValidationException{
		assertNotNull(recintoService.getRecintoObj(1L));
	}
	
	@Test
	@DisplayName("Crear recinto")
	public void testCreate()throws MiValidationException{
		NewRecintoDto newRecinto=new NewRecintoDto();
		newRecinto.setCodigo("R-7");
		newRecinto.setDescripcion("Recinto 7");
		newRecinto.setIdTipoAlimentacion(1L);
		RecintoDto recintoDto= recintoService.create(newRecinto);
		assertNotNull(recintoDto);
	}
	
	@Test
	@DisplayName("Obtener todas los recintos de dinosaurios")
	public void testFindAll() throws MiValidationException {
		List<RecintoDto> resultado= recintoService.findRecintos();
		assertNotNull(resultado);
		assertEquals("Se esperan 7 recintos", 7, resultado.size());
	}
	
	@Test
	@DisplayName("Eliminar recinto lleno")
	public void testDeleteLleno()throws MiValidationException{
		assertNull(recintoService.deleteRecinto(1L));
	}
	
	@Test
	@DisplayName("Eliminar recinto")
	public void testDeleteVacio()throws MiValidationException{
		assertNotNull(recintoService.deleteRecinto(7L));
	}
	
}
