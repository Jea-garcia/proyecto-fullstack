package cl.examen.parkingbnb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private String clienteRut;  // para relacionar con cliente
}
