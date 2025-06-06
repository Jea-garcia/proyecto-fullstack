package cl.examen.parkingbnb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColorDTO {
    private Integer id;
    @NotBlank(message = "El nombre del color es obligatorio")
    private String nombre;

    public ColorDTO() {}
    public ColorDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

