package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.ModeloDTO;

public interface IModeloService {

    ModeloDTO save(ModeloDTO modelo);

    ModeloDTO update(Integer id, ModeloDTO modelo);

    ModeloDTO delete(Integer id);

    ModeloDTO getById(Integer id);

    List<ModeloDTO> getAll();

}
