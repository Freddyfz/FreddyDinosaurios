package es.seresco.cursojee.FreddyEjercicioEspecie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.TipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.TipoAlimentacionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TipoAlimentacionController {

	@Autowired
	private TipoAlimentacionService tipoAlimentacionService;
	
	@GetMapping(path = "/{idTipoAlimentacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAlimentacionDto> getTipoAlimentacion(@PathVariable Long idTipoAlimentacion) throws MiValidationException {
		log.info("Obtiene la tipoAlimentacion por Id");
		TipoAlimentacionDto tipoAlimentacion = tipoAlimentacionService.getTipoAlimentacion(idTipoAlimentacion);

		if (tipoAlimentacion != null) {
			return ResponseEntity.status(HttpStatus.OK).body(tipoAlimentacion);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAlimentacionDto> createTipoAlimentacion(@Validated @RequestBody NewTipoAlimentacionDto newTipoAlimentacion) {
		log.info("Crea un tipoAlimentacion");
		TipoAlimentacionDto tipoAlimentacion = tipoAlimentacionService.create(newTipoAlimentacion);

		if (tipoAlimentacion != null) {
			return ResponseEntity.status(HttpStatus.OK).body(tipoAlimentacion);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoAlimentacionDto>> getTipoAlimentacions() throws MiValidationException {

		List<TipoAlimentacionDto> tipoAlimentacionsEncontradas = tipoAlimentacionService.findTipoAlimentaciones();

		if(tipoAlimentacionsEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(tipoAlimentacionsEncontradas);
		}
	}
	
	@PutMapping(path = "/{idTipoAlimentacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAlimentacionDto> actualizaTipoAlimentacionIdParam(@PathVariable Long idTipoAlimentacion, @Validated @RequestBody NewTipoAlimentacionDto updatedTipoAlimentacion) throws MiValidationException {
		
		tipoAlimentacionService.updateTipoAlimentacion(idTipoAlimentacion,updatedTipoAlimentacion);
		TipoAlimentacionDto dto=tipoAlimentacionService.getTipoAlimentacion(idTipoAlimentacion);
		log.info("TipoAlimentacion actualizado");

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@DeleteMapping(path = "/{idTipoAlimentacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteTipoAlimentacion(@PathVariable Long idTipoAlimentacion) throws MiValidationException {
		tipoAlimentacionService.deleteTipoAlimentacion(idTipoAlimentacion);
	}
	
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAlimentacionDto> actualizaTipoAlimentacion(@Validated @RequestBody TipoAlimentacionDto updatedTipoAlimentacion) throws MiValidationException {
		
		tipoAlimentacionService.updateTipoAlimentacion(updatedTipoAlimentacion);
		return ResponseEntity.status(HttpStatus.OK).body(tipoAlimentacionService.getTipoAlimentacion(updatedTipoAlimentacion.getId()));
	}
}
