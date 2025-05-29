package cl.examen.parkingbnb.service;

import java.util.List;
import cl.examen.parkingbnb.dto.ComunaDTO;

public interface IComunaService {

    ComunaDTO insert(ComunaDTO comuna);

    ComunaDTO update(Long id, ComunaDTO comuna);

    ComunaDTO delete(Long id);

    ComunaDTO getById(Long id);

    List<ComunaDTO> getAll();

}