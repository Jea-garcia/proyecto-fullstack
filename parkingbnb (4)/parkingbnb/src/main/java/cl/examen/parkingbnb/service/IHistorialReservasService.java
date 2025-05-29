package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.HistorialReservasDTO;

public interface IHistorialReservasService {

    HistorialReservasDTO save(HistorialReservasDTO historialReservas);

    HistorialReservasDTO update(Integer id, HistorialReservasDTO historialReservas);

    HistorialReservasDTO delete(Integer id);

    HistorialReservasDTO getById(Integer id);

    List<HistorialReservasDTO> getAll();

}
