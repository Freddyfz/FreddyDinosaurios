package es.seresco.cursojee.FreddyEjercicioEspecie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.seresco.cursojee.FreddyEjercicioEspecie.model.Recinto;

@Repository
public interface RecintoRepository extends JpaRepository<Recinto, Long>{

	@Query("SELECT COUNT(*) FROM Ejemplar e WHERE e.recinto.id = ?1")
	public int countEjemplares(Long recintoId);
}
