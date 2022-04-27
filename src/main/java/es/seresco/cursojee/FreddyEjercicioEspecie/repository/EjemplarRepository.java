package es.seresco.cursojee.FreddyEjercicioEspecie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.cursojee.FreddyEjercicioEspecie.model.Ejemplar;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long>{

	public List<Ejemplar> getByRecintoId(Long idRecinto);
}
