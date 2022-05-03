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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.FamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewFamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Familia;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.FamiliaService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class FamiliaServiceTestCase extends AbstractServiceTestCase{

	@Autowired
	private FamiliaService familiaService;
	
	@Test
	@DisplayName("Obtener familia por id")
	public void testGet() throws MiValidationException {
		Familia familia=familiaService.getFamiliaObj(1L);
		assertNotNull(familia);
	}
	
	@Test
	@DisplayName("Crear una familia")
	public void testCreate() throws MiValidationException {
		NewFamiliaDto newFamiliaDto=new NewFamiliaDto();
		newFamiliaDto.setNombre("Pterodactylus");
		assertNotNull(familiaService.create(newFamiliaDto));
	}
	
	@Test
	@DisplayName("Obtener todas las familias de dinosaurios")
	public void testFindAll() throws MiValidationException {
		List<FamiliaDto> resultado= familiaService.findFamilias();
		assertNotNull(resultado);
		assertEquals("Se esperan 3 familias", 3, resultado.size());
	}
	
	@Test
	@DisplayName("Update id, newFamiliaDto")
	public void testUpdate() throws MiValidationException {
		NewFamiliaDto newFamiliaDto=new NewFamiliaDto();
		newFamiliaDto.setNombre("Pterodactylus");
		assertNotNull(familiaService.updateFamiliaObj(1L,newFamiliaDto));
	}
	
	@Test
	@DisplayName("Update FamiliaDto")
	public void testUpdateDto() throws MiValidationException {
		FamiliaDto FamiliaDto=new FamiliaDto();
		FamiliaDto.setId(1L);
		FamiliaDto.setNombre("Pterodactylus");
		assertNotNull(familiaService.updateFamiliaObj(FamiliaDto));
	}
	
	@Test
	@DisplayName("Delete familia existente sin especies")
	public void testDelete() throws MiValidationException {
		NewFamiliaDto newFamiliaDto=new NewFamiliaDto();
		newFamiliaDto.setNombre("Pterodactylus");
		FamiliaDto familiaDto =familiaService.create(newFamiliaDto);
		familiaService.deleteFamilia(familiaDto.getId());
	}
	
	@Test
	@DisplayName("Delete familia que no existe")
	public void testDeleteNoExist() throws MiValidationException {
		familiaService.deleteFamilia(10L);
	}
}
