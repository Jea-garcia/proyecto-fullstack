package cl.examen.parkingbnb.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.ClienteDTO;
import cl.examen.parkingbnb.dto.ComunaDTO;
import cl.examen.parkingbnb.model.ClienteModel;
import cl.examen.parkingbnb.model.ComunaModel;
import cl.examen.parkingbnb.repository.ClienteRepository;
import cl.examen.parkingbnb.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;

    @Override
    public ClienteDTO insert(ClienteDTO clienteDTO) {
        ClienteModel cliente = mapToEntity(clienteDTO);
        ClienteModel saved = repository.save(cliente);
        return mapToDTO(saved);
    }

    @Override
    public ClienteDTO update(String rut, ClienteDTO clienteDTO) {
        Optional<ClienteModel> existingOpt = repository.findById(rut);
        if (existingOpt.isPresent()) {
            ClienteModel existing = existingOpt.get();
            existing.setDv(clienteDTO.getDv());
            existing.setNombre(clienteDTO.getNombre());
            existing.setApellidoP(clienteDTO.getApellidoP());
            existing.setApellidoM(clienteDTO.getApellidoM());
            existing.setDireccion(clienteDTO.getDireccion());
            existing.setEmail(clienteDTO.getEmail());

           if (clienteDTO.getFechaNacimiento() != null && !clienteDTO.getFechaNacimiento().isEmpty()) {
    LocalDate localDate = LocalDate.parse(clienteDTO.getFechaNacimiento(), FORMATTER);
    existing.setFechaNac(localDate);
}

            existing.setTelefono(clienteDTO.getTelefono());
            existing.setCelular(clienteDTO.getCelular());

            if (clienteDTO.getComuna() != null) {
                ComunaModel comuna = new ComunaModel();
                comuna.setId(clienteDTO.getComuna().getId());
                existing.setComuna(comuna);
            }

            ClienteModel updated = repository.save(existing);
            return mapToDTO(updated);
        }
        return null;
    }

    @Override
    public ClienteDTO delete(String rut) {
        Optional<ClienteModel> existingOpt = repository.findById(rut);
        if (existingOpt.isPresent()) {
            ClienteModel cliente = existingOpt.get();
            repository.deleteById(rut);
            return mapToDTO(cliente);
        }
        return null;
    }

    @Override
    public ClienteDTO getByRut(String rut) {
        return repository.findById(rut).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<ClienteDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    private ClienteModel mapToEntity(ClienteDTO dto) {
        ClienteModel entity = new ClienteModel();
        entity.setRut(dto.getRut());
        entity.setDv(dto.getDv());
        entity.setNombre(dto.getNombre());
        entity.setApellidoP(dto.getApellidoP());
        entity.setApellidoM(dto.getApellidoM());
        entity.setDireccion(dto.getDireccion());
        entity.setEmail(dto.getEmail());

        if (dto.getFechaNacimiento() != null && !dto.getFechaNacimiento().isEmpty()) {
    LocalDate localDate = LocalDate.parse(dto.getFechaNacimiento(), FORMATTER);
    entity.setFechaNac(localDate);
}   
        entity.setTelefono(dto.getTelefono());
        entity.setCelular(dto.getCelular());

        if (dto.getComuna() != null) {
            ComunaModel comunaModel = new ComunaModel();
            comunaModel.setId(dto.getComuna().getId());
            comunaModel.setNombre(dto.getComuna().getNombre());
            entity.setComuna(comunaModel);
        }
        return entity;
    }

    private ClienteDTO mapToDTO(ClienteModel entity) {
        if (entity == null) return null;
        ClienteDTO dto = new ClienteDTO();
        dto.setRut(entity.getRut());
        dto.setDv(entity.getDv());
        dto.setNombre(entity.getNombre());
        dto.setApellidoP(entity.getApellidoP());
        dto.setApellidoM(entity.getApellidoM());
        dto.setDireccion(entity.getDireccion());
        dto.setEmail(entity.getEmail());

    if (entity.getFechaNac() != null) {
    dto.setFechaNacimiento(entity.getFechaNac().format(FORMATTER));
}
        dto.setTelefono(entity.getTelefono());
        dto.setCelular(entity.getCelular());

        if (entity.getComuna() != null) {
            ComunaDTO comunaDTO = new ComunaDTO();
            comunaDTO.setId(entity.getComuna().getId());
            comunaDTO.setNombre(entity.getComuna().getNombre());
            dto.setComuna(comunaDTO);
        }
        return dto;
    }
}
