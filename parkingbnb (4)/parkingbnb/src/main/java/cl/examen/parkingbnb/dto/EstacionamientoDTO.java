package cl.examen.parkingbnb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstacionamientoDTO {
    private int id;
    private String ubicacion;
    private String tipo;
    private String estado;
    private double tarifa;
}
