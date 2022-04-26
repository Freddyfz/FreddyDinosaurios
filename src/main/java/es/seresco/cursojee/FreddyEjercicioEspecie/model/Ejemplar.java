package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "EJEMPLAR")
public class Ejemplar implements Serializable{
	
	private static final long serialVersionUID = 5696792052820833716L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ID_ESPECIE")
    private Long idEspecie;
	
	@Column(name = "NOMBRE",length = 50)
	private String nombre;
	
	@Column(name = "SEXO",length = 50)
	private String sexo;
	
    @Column(name = "ID_RECINTO")
    private Long idRecinto;
}
