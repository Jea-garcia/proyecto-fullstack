package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estacionamiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstacionamientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estacionamiento_seq")
    @SequenceGenerator(name = "estacionamiento_seq", sequenceName = "ESTACIONAMIENTO_SEQ", allocationSize = 1)
    private Long id;

    private String ubicacion;
    private String tipo;
    private String estado;
    private double tarifa;
}
