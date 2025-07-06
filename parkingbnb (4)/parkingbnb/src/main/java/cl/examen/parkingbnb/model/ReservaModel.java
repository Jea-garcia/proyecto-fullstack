package cl.examen.parkingbnb.model;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // Ajusta el nombre según tu base de datos
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "estacionamiento_id") // Ajusta el nombre según tu base de datos
    private EstacionamientoModel estacionamiento;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String estado;
    private double total;
}
