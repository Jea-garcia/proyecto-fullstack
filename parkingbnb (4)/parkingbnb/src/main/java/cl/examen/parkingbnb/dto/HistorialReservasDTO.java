package cl.examen.parkingbnb.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class HistorialReservasDTO {

    private Long id;
    private Long clienteId; 
    private Long reservaId;
    private LocalDateTime fechaHora;
    private String estado;
    public void setReservaId(int id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setReservaId'");
    }

}
