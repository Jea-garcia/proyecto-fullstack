package cl.examen.parkingbnb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehiculoDTO {
    private String patente;
    private ClienteDTO cliente;  
    private String clienteRut;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
}

