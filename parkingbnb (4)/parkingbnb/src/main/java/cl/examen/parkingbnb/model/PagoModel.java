package cl.examen.parkingbnb.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pago")
@Getter
@Setter
public class PagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private ReservaModel reserva;

    private double monto;

    private String metodoPago;

    private LocalDateTime fechaPago;
}