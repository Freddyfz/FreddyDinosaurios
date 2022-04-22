package es.seresco.cursojee.FreddyEjercicioEspecie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.cursojee.FreddyEjercicioEspecie.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long>{

}
