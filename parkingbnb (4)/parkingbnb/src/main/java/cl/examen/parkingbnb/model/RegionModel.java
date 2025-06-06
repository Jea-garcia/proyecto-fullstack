package cl.examen.parkingbnb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "region")
public class RegionModel {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(name = "region_seq", sequenceName = "region_seq", allocationSize = 1)
    private Integer id;
    private String nombre;
}
