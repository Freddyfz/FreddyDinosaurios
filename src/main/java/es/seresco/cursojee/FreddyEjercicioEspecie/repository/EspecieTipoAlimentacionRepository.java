package es.seresco.cursojee.FreddyEjercicioEspecie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacionPK;

@Repository
public interface EspecieTipoAlimentacionRepository extends JpaRepository<EspecieTipoAlimentacion, EspecieTipoAlimentacionPK>{

}
