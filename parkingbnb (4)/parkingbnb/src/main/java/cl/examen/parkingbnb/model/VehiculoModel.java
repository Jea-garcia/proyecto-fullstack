package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
    @SequenceGenerator(name = "vehiculo_seq", sequenceName = "VEHICULO_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String patente;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private int anio;

    // Relación con Cliente (supongo que un vehículo pertenece a un cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_rut", nullable = false)
    private ClienteModel cliente;
}
