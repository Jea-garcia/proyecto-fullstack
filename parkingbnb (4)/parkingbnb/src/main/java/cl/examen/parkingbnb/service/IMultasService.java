package cl.examen.parkingbnb.service;

import java.util.List;
import cl.examen.parkingbnb.dto.MultasDTO;

public interface IMultasService {
    MultasDTO save(MultasDTO multas);
    MultasDTO update(Integer id, MultasDTO multas);
    MultasDTO delete(Integer id);
    MultasDTO getById(Integer id);
    List<MultasDTO> getAll();
}