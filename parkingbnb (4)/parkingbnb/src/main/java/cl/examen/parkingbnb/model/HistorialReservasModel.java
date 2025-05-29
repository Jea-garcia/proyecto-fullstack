package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "historial_reservas")
public class HistorialReservasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Por ejemplo, relación con usuario (cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    // Relación con reserva
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private ReservaModel reserva;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "estado")
    private String estado;

    // getters y setters
}
