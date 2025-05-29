package cl.examen.parkingbnb.model;

import java.time.LocalDateTime;

import cl.examen.parkingbnb.dto.ClienteDTO;
import cl.examen.parkingbnb.dto.EstacionamientoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setCliente(ClienteModel clienteModel) {
        throw new UnsupportedOperationException("Unimplemented method 'setCliente'");
    }

    public void setEstacionamiento(EstacionamientoModel estacionamientoModel) {
        throw new UnsupportedOperationException("Unimplemented method 'setEstacionamiento'");
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaHoraInicio'");
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaHoraFin'");
    }

    public void setEstado(String estado) {
        throw new UnsupportedOperationException("Unimplemented method 'setEstado'");
    }

    public void setTotal(double total) {
        throw new UnsupportedOperationException("Unimplemented method 'setTotal'");
    }

    public ClienteDTO getCliente() {
        throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
    }

    public LocalDateTime getFechaHoraInicio() {
        throw new UnsupportedOperationException("Unimplemented method 'getFechaHoraInicio'");
    }

    public LocalDateTime getFechaHoraFin() {
        throw new UnsupportedOperationException("Unimplemented method 'getFechaHoraFin'");
    }

    public String getEstado() {
        throw new UnsupportedOperationException("Unimplemented method 'getEstado'");
    }

    public double getTotal() {
        throw new UnsupportedOperationException("Unimplemented method 'getTotal'");
    }

    public EstacionamientoDTO getEstacionamiento() {
        throw new UnsupportedOperationException("Unimplemented method 'getEstacionamiento'");
    }

}