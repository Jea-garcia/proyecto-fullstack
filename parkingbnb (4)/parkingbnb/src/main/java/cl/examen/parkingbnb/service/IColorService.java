package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.ColorDTO;

public interface IColorService {

    ColorDTO insert(ColorDTO color);

    ColorDTO update(Integer id, ColorDTO color);

    ColorDTO delete(Integer id);

    ColorDTO getById(Integer id);

    List<ColorDTO> getAll();

}
