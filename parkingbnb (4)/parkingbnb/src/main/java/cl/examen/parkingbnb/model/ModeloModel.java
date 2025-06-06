package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modelo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModeloModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaModel marca;
}
