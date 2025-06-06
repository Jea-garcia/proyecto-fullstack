package cl.examen.parkingbnb.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "color")
public class ColorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_seq")
    @SequenceGenerator(name = "color_seq", sequenceName = "color_seq", allocationSize = 1)
    private Integer id;

    private String nombre;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
