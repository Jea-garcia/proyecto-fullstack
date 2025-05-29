package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.MarcaDTO;

public interface IMarcaService {

    MarcaDTO save(MarcaDTO marca);

    MarcaDTO update(Integer id, MarcaDTO marca);

    MarcaDTO delete(Integer id);

    MarcaDTO getById(Integer id);

    List<MarcaDTO> getAll();

}
