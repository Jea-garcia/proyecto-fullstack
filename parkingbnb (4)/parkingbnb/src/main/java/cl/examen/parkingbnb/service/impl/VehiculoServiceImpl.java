package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.VehiculoDTO;
import cl.examen.parkingbnb.model.ClienteModel;
import cl.examen.parkingbnb.model.VehiculoModel;
import cl.examen.parkingbnb.repository.ClienteRepository;
import cl.examen.parkingbnb.repository.VehiculoRepository;
import cl.examen.parkingbnb.service.IVehiculoService;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
    
    @Autowired
    VehiculoRepository repositoryVehiculo;

    @Autowired
    ClienteRepository clienteRepository;

    private VehiculoDTO modelToDTO(VehiculoModel model) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setPatente(model.getPatente());
        dto.setMarca(model.getMarca());
        dto.setModelo(model.getModelo());
        dto.setColor(model.getColor());
        dto.setTipo(model.getTipo());
        dto.setClienteRut(model.getCliente().getRut());
        return dto;
    }

    private VehiculoModel dtoToModel(VehiculoDTO dto) {
        VehiculoModel model = new VehiculoModel();
        model.setPatente(dto.getPatente());
        model.setMarca(dto.getMarca());
        model.setModelo(dto.getModelo());
        model.setColor(dto.getColor());
        model.setTipo(dto.getTipo());

        Optional<ClienteModel> cliente = clienteRepository.findById(dto.getClienteRut());
        model.setCliente(cliente.orElse(null));
        return model;
    }

    @Override
    public VehiculoDTO save(VehiculoDTO vehiculo) {
        VehiculoModel model = dtoToModel(vehiculo);
        VehiculoModel saved = repositoryVehiculo.save(model);
        return modelToDTO(saved);
    }

    @Override
    public VehiculoDTO update(String patente, VehiculoDTO vehiculo) {
        VehiculoModel model = dtoToModel(vehiculo);
        VehiculoModel updated = repositoryVehiculo.save(model);
        return modelToDTO(updated);
    }

    @Override
    public VehiculoDTO delete(String patente) {
        Optional<VehiculoModel> optional = repositoryVehiculo.findById(patente);
        if (optional.isPresent()) {
            VehiculoModel model = optional.get();
            repositoryVehiculo.deleteById(patente);
            return modelToDTO(model);
        }
        return null;
    }

    @Override
    public VehiculoDTO getById(String patente) {
        return repositoryVehiculo.findById(patente)
                .map(this::modelToDTO)
                .orElse(null);
    }

    @Override
    public List<VehiculoDTO> getAll() {
        return (List<VehiculoDTO>) repositoryVehiculo.findAll()
                .stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }
}
