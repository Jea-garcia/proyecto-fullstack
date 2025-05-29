package cl.examen.parkingbnb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Getter
@Setter
@AllArgsConstructor
@Entity
public class EstacionamientoModel {

   @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estacionamiento_seq")
@SequenceGenerator(name = "estacionamiento_seq", sequenceName = "ESTACIONAMIENTO_SEQ", allocationSize = 1)
@Column(name = "id")
    private Long id;

    private String nombre;
    private String ubicacion;
    
    public void setCampo(Object campo) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setCampo'");
    }
    public Object getCampo() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getCampo'");
    }
    public void setId(int id2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    public EstacionamientoModel(int id2) {
        
    }

    
}