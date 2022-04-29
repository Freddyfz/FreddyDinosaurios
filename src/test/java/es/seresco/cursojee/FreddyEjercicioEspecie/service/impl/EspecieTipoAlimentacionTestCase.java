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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.core.Application;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacionPK;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieTipoAlimentacionService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@TestPropertySource(locations = "classpath:/dbunit/application-test.properties")
public class EspecieTipoAlimentacionTestCase extends AbstractServiceTestCase{

	@Autowired
	private EspecieTipoAlimentacionService especieTipoAlimentacionService;
	
	@Test
	@DisplayName("Obtener especieTipoAlimentacion por id")
	public void testGet() throws MiValidationException {
		EspecieTipoAlimentacionPK especieTipoAlimentacionPK=new EspecieTipoAlimentacionPK();
		especieTipoAlimentacionPK.setIdEspecie(8L);
		especieTipoAlimentacionPK.setIdTipoAlimentacion(1L);
		EspecieTipoAlimentacion especieTipoAlimentacion=especieTipoAlimentacionService.getEspecieTipoAlimentacionObj(especieTipoAlimentacionPK);
		assertNotNull(especieTipoAlimentacion);
	}
	
	@Test
	@DisplayName("Crear una especieTipoAlimentacion")
	public void testCreate() throws MiValidationException {
		EspecieTipoAlimentacion especieTipoAlimentacion=new EspecieTipoAlimentacion();
		especieTipoAlimentacion.setIdEspecie(8L);
		especieTipoAlimentacion.setIdTipoAlimentacion(2L);
		assertNotNull(especieTipoAlimentacionService.create(especieTipoAlimentacion));
	}
	
	@Test
	@DisplayName("Obtener todos los registros de especieTipoAlimentaciones")
	public void testFindAll() throws MiValidationException {
		List<EspecieTipoAlimentacionDto> resultado= especieTipoAlimentacionService.findEspecieTipoAlimentaciones();
		assertNotNull(resultado);
		assertEquals("Se esperan 3 especieTipoAlimentacions", 8, resultado.size());
	}
	
	@Test
	@DisplayName("Delete especieTipoAlimentacion existente")
	public void testDelete() throws MiValidationException {
		EspecieTipoAlimentacionPK especieTipoAlimentacionPK=new EspecieTipoAlimentacionPK();
		especieTipoAlimentacionPK.setIdEspecie(8L);
		especieTipoAlimentacionPK.setIdTipoAlimentacion(1L);
		especieTipoAlimentacionService.deleteEspecieTipoAlimentacion(especieTipoAlimentacionPK);
	}
	
	@Test
	@DisplayName("Delete especieTipoAlimentacion que no existe")
	public void testDeleteNoExist() throws MiValidationException {
		EspecieTipoAlimentacionPK especieTipoAlimentacionPK=new EspecieTipoAlimentacionPK();
		especieTipoAlimentacionPK.setIdEspecie(16L);
		especieTipoAlimentacionPK.setIdTipoAlimentacion(4L);
		especieTipoAlimentacionService.deleteEspecieTipoAlimentacion(especieTipoAlimentacionPK);
	}
}
