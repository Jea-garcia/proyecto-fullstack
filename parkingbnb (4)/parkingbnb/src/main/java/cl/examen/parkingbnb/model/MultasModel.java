package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "multas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MultasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private ReservaModel reserva;

    private String motivo;
    private double monto;
    private LocalDateTime fecha;
    private String estado;
}