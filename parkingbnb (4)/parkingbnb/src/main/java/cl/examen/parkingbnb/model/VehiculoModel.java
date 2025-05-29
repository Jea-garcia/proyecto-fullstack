package cl.examen.parkingbnb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehiculo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehiculoModel {

    @Id
    @Column(name = "patente")
    private String patente;

    @ManyToOne
    @JoinColumn(name = "cliente_rut")
    private ClienteModel cliente;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @Column(name = "tipo")
    private String tipo;
}
