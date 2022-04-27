package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ESPECIE_TIPO_ALIMENTACION")
@IdClass(EspecieTipoAlimentacionPK.class)
public class EspecieTipoAlimentacion implements Serializable{
	
	private static final long serialVersionUID = -1399472818674786358L;

	@Id
	@Column(name="ID_ESPECIE")
	private Long idEspecie;
	
	@Id
	@Column(name="ID_TIPO_ALIMENTACION")
	private Long idTipoAlimentacion;
	
	@ManyToOne
    @JoinColumn(name = "ID_ESPECIE",insertable = false, updatable = false)
    private Especie especie;
	
	@ManyToOne
    @JoinColumn(name = "ID_TIPO_ALIMENTACION",insertable = false, updatable = false)
    private TipoAlimentacion tipoAlimentacion;
}

