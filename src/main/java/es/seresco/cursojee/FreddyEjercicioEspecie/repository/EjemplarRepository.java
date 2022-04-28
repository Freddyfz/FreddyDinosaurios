package es.seresco.cursojee.FreddyEjercicioEspecie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.seresco.cursojee.FreddyEjercicioEspecie.model.Ejemplar;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.TipoAlimentacion;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long>{

	public List<Ejemplar> getByRecintoId(Long idRecinto);
	
	@Query("SELECT e.recinto.tipoAlimentacion FROM Ejemplar e WHERE e.recinto.id = ?1")
	public TipoAlimentacion getTipoAlimentacion(Long idRecinto);
	
	@Query("SELECT et FROM EspecieTipoAlimentacion et WHERE et.idEspecie = "
			+ "(SELECT e.id FROM et.especie e WHERE e.id=?1) "
			+ "AND "
			+ "et.idTipoAlimentacion = "
			+ "(SELECT ta.id FROM et.tipoAlimentacion ta WHERE ta.id = "
			+ "(SELECT e.id FROM et.especie e WHERE e.id=?1))")
	public EspecieTipoAlimentacion comprobarTipoAlimentacion(Long idEspecie,Long idRecinto);

	@Query("SELECT ejemplar.especie.tipoAlimentacion FROM Ejemplar ejemplar "
			+ "WHERE ejemplar.especie.id = ?1")
	public Long comprobarTipoAlimentacionEspecie(Long idEspecie);

	@Query("SELECT r.tipoAlimentacion FROM Recinto r WHERE r.id = ?1")
	public Long comprobarTipoAlimentacionRecinto(Long idRecinto);
}
