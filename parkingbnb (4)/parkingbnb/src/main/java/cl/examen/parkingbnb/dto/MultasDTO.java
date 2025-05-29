package cl.examen.parkingbnb.dto;

import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MultasDTO {
    private int id;

    private Integer reservaId;
    private String motivo;
    private double monto;
    private LocalDateTime fecha;
    private String estado;
}