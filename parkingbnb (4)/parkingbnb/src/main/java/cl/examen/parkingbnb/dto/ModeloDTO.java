package cl.examen.parkingbnb.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ModeloDTO {
    private int id;
    private String nombre;
    private MarcaDTO marca;
}
