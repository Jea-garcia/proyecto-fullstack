package cl.examen.parkingbnb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.examen.parkingbnb.dto.MultasDTO;
import cl.examen.parkingbnb.model.MultasModel;
import cl.examen.parkingbnb.model.ReservaModel;
import cl.examen.parkingbnb.repository.ReservaRepository;

@Component
public class MultasMapper {

    @Autowired
    private ReservaRepository reservaRepo;

    public MultasDTO toDTO(MultasModel multa) {
        if (multa == null || multa.getReserva() == null) return null;

        MultasDTO dto = new MultasDTO();
        dto.setId(multa.getId());
        dto.setReservaId(multa.getReserva().getId());
        dto.setMotivo(multa.getMotivo());
        dto.setMonto(multa.getMonto());
        dto.setFecha(multa.getFecha());
        dto.setEstado(multa.getEstado());
        return dto;
    }

    public MultasModel toEntity(MultasDTO dto) {
        if (dto == null) return null;

        MultasModel multa = new MultasModel();
        multa.setId(dto.getId());
        ReservaModel reserva = reservaRepo.findById(dto.getReservaId())
            .orElseThrow(() -> new IllegalArgumentException("Reserva con ID " + dto.getReservaId() + " no encontrada."));
        multa.setReserva(reserva);
        multa.setMotivo(dto.getMotivo());
        multa.setMonto(dto.getMonto());
        multa.setFecha(dto.getFecha());
        multa.setEstado(dto.getEstado());
        return multa;
    }
}