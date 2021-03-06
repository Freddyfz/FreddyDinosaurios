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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Ejemplar;
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
	@DisplayName("Crear ejemplar con recinto disponible pero de otro tipo de comida")
	public void testCreateDispCarn()throws MiValidationException{
		NewEjemplarDto newEjemplarDto=new NewEjemplarDto();
		newEjemplarDto.setNombre("Juanjo");
		newEjemplarDto.setIdRecinto(6L);
		newEjemplarDto.setIdEspecie(4L);
		newEjemplarDto.setSexo("MACHO");
		assertNull(ejemplarService.createObj(newEjemplarDto));
	}
	
	@Test
	@DisplayName("Crear ejemplar con recinto disponible")
	public void testCreateDisp()throws MiValidationException{
		NewEjemplarDto newEjemplarDto=new NewEjemplarDto();
		newEjemplarDto.setNombre("Juanjo");
		newEjemplarDto.setIdRecinto(7L);
		newEjemplarDto.setIdEspecie(2L);
		newEjemplarDto.setSexo("MACHO");
		assertNotNull(ejemplarService.createObj(newEjemplarDto));
	}
	
	@Test
	@DisplayName("Obtener todas las ejemplares")
	public void testFindAll() throws MiValidationException {
		List<EjemplarDto> resultado= ejemplarService.findEjemplares();
		assertNotNull(resultado);
		assertEquals("Se esperan 8 ejemplars", 20, resultado.size());
	}
	
	@Test
	@DisplayName("Obtener ejemplar por id")
	public void testGet() throws MiValidationException {
		Ejemplar ejemplar=ejemplarService.getEjemplarObj(1L);
		assertNotNull(ejemplar);
	}
	
	@Test
	@DisplayName("Update id, newEjemplarDto")
	public void testUpdate() throws MiValidationException {
		NewEjemplarDto newEjemplarDto=new NewEjemplarDto();
		newEjemplarDto.setNombre("Aerodactilos");
		assertNotNull(ejemplarService.updateEjemplarObj(1L,newEjemplarDto));
	}
	
	@Test
	@DisplayName("Update EjemplarDto")
	public void testUpdateDto() throws MiValidationException {
		EjemplarDto ejemplarDto=new EjemplarDto();
		ejemplarDto.setIdEspecie(1L);
		ejemplarDto.setIdRecinto(1L);
		ejemplarDto.setId(1L);
		ejemplarDto.setNombre("Pterodactylus");
		assertNotNull(ejemplarService.updateEjemplarObj(ejemplarDto));
	}
	
	@Test
	@DisplayName("Delete ejemplar")
	public void testDeleteNoExist() throws MiValidationException {
		ejemplarService.deleteEjemplar(10L);
	}
}
