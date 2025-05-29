package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.EstacionamientoDTO;

public interface IEstacionamientoService {

    EstacionamientoDTO save(EstacionamientoDTO estacionamiento);

    EstacionamientoDTO update(Integer id, EstacionamientoDTO estacionamiento);

    EstacionamientoDTO delete(Integer id);

    EstacionamientoDTO getById(Integer id);

    List<EstacionamientoDTO> getAll();

}
