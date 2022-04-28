package es.seresco.cursojee.FreddyEjercicioEspecie.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Especie;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class EspecieServiceTestCase extends AbstractServiceTestCase{

	@Autowired
	private EspecieService especieService;
	
	@Test
	@DisplayName("Obtener todas las especies de dinosaurios")
	public void testFindAll() throws MiValidationException {
		List<EspecieDto> resultado= especieService.findEspecies();
		assertNotNull(resultado);
		assertEquals("Se esperan 8 especies", 8, resultado.size());
	}
	
	@Test
	@DisplayName("Obtener especie por id")
	public void testGet() throws MiValidationException {
		Especie especie=especieService.getEspecieObj(1L);
		assertNotNull(especie);
	}
	
	@Test
	@DisplayName("Crear una especie")
	public void testCreate() throws MiValidationException {
		NewEspecieDto newEspecieDto=new NewEspecieDto();
		newEspecieDto.setIdFamilia(1L);
		newEspecieDto.setNombre("Aerodactilos");
		assertNotNull(especieService.create(newEspecieDto));
	}
	
	@Test
	@DisplayName("Update id, newEspecieDto")
	public void testUpdate() throws MiValidationException {
		NewEspecieDto newEspecieDto=new NewEspecieDto();
		newEspecieDto.setIdFamilia(1L);
		newEspecieDto.setNombre("Aerodactilos");
		assertNotNull(especieService.updateEspecieObj(1L,newEspecieDto));
	}
	
	@Test
	@DisplayName("Update EspecieDto")
	public void testUpdateDto() throws MiValidationException {
		EspecieDto EspecieDto=new EspecieDto();
		EspecieDto.setId(1L);
		EspecieDto.setNombre("Pterodactylus");
		assertNotNull(especieService.updateEspecieObj(EspecieDto));
	}
	
	@Test
	@DisplayName("Delete especie")
	public void testDeleteNoExist() throws MiValidationException {
		especieService.deleteEspecie(10L);
	}
}