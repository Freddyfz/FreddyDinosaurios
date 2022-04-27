package es.seresco.cursojee.FreddyEjercicioEspecie.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.GlobalAppExceptionHandler;

@Configuration
@EnableJpaRepositories({ "es.seresco.cursojee.FreddyEjercicioEspecie.repository" })
@ComponentScan(basePackages = { "es.seresco.cursojee.FreddyEjercicioEspecie" })
@EntityScan({ "es.seresco.cursojee.FreddyEjercicioEspecie.model" })
@EnableTransactionManagement
@Import(GlobalAppExceptionHandler.class)
public class DinosaurioConfig {

}
