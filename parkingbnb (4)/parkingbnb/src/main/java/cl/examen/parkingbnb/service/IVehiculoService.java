package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.VehiculoDTO;

public interface IVehiculoService {

    VehiculoDTO save(VehiculoDTO vehiculo);

    VehiculoDTO update(String patente, VehiculoDTO vehiculo);

    VehiculoDTO delete(String patente);

    VehiculoDTO getById(String patente);

    List<VehiculoDTO> getAll();

}
