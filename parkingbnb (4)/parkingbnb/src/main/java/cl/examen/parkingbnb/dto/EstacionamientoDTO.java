package cl.examen.parkingbnb.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estacionamiento")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstacionamientoDTO {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "ubicacion")
    private String ubicacion;
    @Column (name = "tipo")
    private String tipo;
    @Column (name = "estado")
    private String estado;
    @Column (name = "tarifa")
    private double tarifa;
    public Object getCampo() {
        throw new UnsupportedOperationException("Unimplemented method 'getCampo'");
    }
    public void setId(Long id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    public void setCampo(Object campo) {
        throw new UnsupportedOperationException("Unimplemented method 'setCampo'");
    }

}
