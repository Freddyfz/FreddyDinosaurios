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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.TipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.TipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.TipoAlimentacionService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class TipoALimentacionTestCase extends AbstractServiceTestCase{

	@Autowired
	private TipoAlimentacionService tipoAlimentacionService;
	
	@Test
	@DisplayName("Obtener tipoAlimentacion por id")
	public void testGet() throws MiValidationException {
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionService.getTipoAlimentacionObj(1L);
		assertNotNull(tipoAlimentacion);
	}
	
	@Test
	@DisplayName("Crear una tipoAlimentacion")
	public void testCreate() throws MiValidationException {
		NewTipoAlimentacionDto newTipoAlimentacionDto=new NewTipoAlimentacionDto();
		newTipoAlimentacionDto.setDescripcion("Omnivoro");
		assertNotNull(tipoAlimentacionService.create(newTipoAlimentacionDto));
	}
	
	@Test
	@DisplayName("Obtener todas las tipoAlimentacions de dinosaurios")
	public void testFindAll() throws MiValidationException {
		List<TipoAlimentacionDto> resultado= tipoAlimentacionService.findTipoAlimentaciones();
		assertNotNull(resultado);
		assertEquals("Se esperan 3 tipoAlimentacions", 2, resultado.size());
	}
	
	@Test
	@DisplayName("Update id, newTipoAlimentacionDto")
	public void testUpdate() throws MiValidationException {
		NewTipoAlimentacionDto newTipoAlimentacionDto=new NewTipoAlimentacionDto();
		newTipoAlimentacionDto.setDescripcion("Omnivoro");
		assertNotNull(tipoAlimentacionService.updateTipoAlimentacionObj(1L,newTipoAlimentacionDto));
	}
	
	@Test
	@DisplayName("Update TipoAlimentacionDto")
	public void testUpdateDto() throws MiValidationException {
		TipoAlimentacionDto TipoAlimentacionDto=new TipoAlimentacionDto();
		TipoAlimentacionDto.setId(1L);
		assertNotNull(tipoAlimentacionService.updateTipoAlimentacionObj(TipoAlimentacionDto));
	}
	
	@Test
	@DisplayName("Delete tipoAlimentacion existente sin especies")
	public void testDelete() throws MiValidationException {
		NewTipoAlimentacionDto newTipoAlimentacionDto=new NewTipoAlimentacionDto();
		TipoAlimentacionDto tipoAlimentacionDto =tipoAlimentacionService.create(newTipoAlimentacionDto);
		tipoAlimentacionService.deleteTipoAlimentacion(tipoAlimentacionDto.getId());
	}
	
	@Test
	@DisplayName("Delete tipoAlimentacion que no existe")
	public void testDeleteNoExist() throws MiValidationException {
		tipoAlimentacionService.deleteTipoAlimentacion(10L);
	}
}
