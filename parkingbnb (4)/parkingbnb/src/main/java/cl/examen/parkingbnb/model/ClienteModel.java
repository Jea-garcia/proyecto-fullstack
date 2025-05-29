package cl.examen.parkingbnb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    @Id
    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "dv")
    private String dv;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidop")
    private String apellidoP;

    @Column(name = "apellidom")
    private String apellidoM;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_nac")
    private java.time.LocalDate fechaNac;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular", nullable = false)
    private String celular;

    @ManyToOne
    @JoinColumn(name = "ID_COMUNA", nullable = false)
    private ComunaModel comuna;

    public Long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    
}
