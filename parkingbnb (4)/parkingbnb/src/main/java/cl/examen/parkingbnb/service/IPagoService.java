package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.PagoDTO;

public interface IPagoService {

    PagoDTO save(PagoDTO pago);

    PagoDTO update(Integer id, PagoDTO pago);

    PagoDTO delete(Integer id);

    PagoDTO getById(Integer id);

    List<PagoDTO> getAll();

}
