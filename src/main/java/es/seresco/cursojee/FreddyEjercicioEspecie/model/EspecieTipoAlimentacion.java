package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Especie_Tipo_Alimentacion")
public class EspecieTipoAlimentacion implements Serializable{
	
	private static final long serialVersionUID = -1399472818674786358L;
	
	@EmbeddedId
	private EspecieTipoAlimentacionPK  especieTipoAlimentacionPK;
	
	@ManyToOne
    @JoinColumn(name = "id_Especie", insertable = false, updatable = false)
    private Especie especie;
	
	@ManyToOne
    @JoinColumn(name = "id_Tipo_Alimentacion", insertable = false, updatable = false)
    private TipoAlimentacion tipoAlimentacion;
}
