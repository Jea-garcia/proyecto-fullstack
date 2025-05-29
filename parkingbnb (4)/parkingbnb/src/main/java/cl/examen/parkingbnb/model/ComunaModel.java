package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comuna")
public class ComunaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comuna_seq")
    @SequenceGenerator(name = "comuna_seq", sequenceName = "SEQ_COMUNA", allocationSize = 1)
    private Long id;

    private String nombre;

    // IMPORTANTE: Elimina cualquier método `toEntity()` de aquí si lo tenías antes
}
