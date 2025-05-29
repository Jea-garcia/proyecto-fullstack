package cl.examen.parkingbnb.dto;

import java.time.LocalDateTime;

import cl.examen.parkingbnb.model.ReservaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagoDTO {
    private int id;
    private int reservaId;
    private double monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
    public PagoDTO getReserva() {
        throw new UnsupportedOperationException("Unimplemented method 'getReserva'");
    }
    public void setReserva(ReservaModel reserva) {
        throw new UnsupportedOperationException("Unimplemented method 'setReserva'");
    }
}
