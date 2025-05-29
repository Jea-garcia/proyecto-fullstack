package cl.examen.parkingbnb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marca")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarcaModel {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
}
