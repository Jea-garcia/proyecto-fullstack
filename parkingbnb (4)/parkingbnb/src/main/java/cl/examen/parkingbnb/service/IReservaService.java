package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.ReservaDTO;

public interface IReservaService {

    ReservaDTO save(ReservaDTO reserva);

    ReservaDTO update(Integer id, ReservaDTO reserva);

    ReservaDTO delete(Integer id);

    ReservaDTO getById(Integer id);

    List<ReservaDTO> getAll();

}
