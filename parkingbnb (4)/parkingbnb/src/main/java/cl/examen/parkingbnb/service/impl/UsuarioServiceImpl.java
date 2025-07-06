package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.UsuarioDTO;
import cl.examen.parkingbnb.mapper.UsuarioMapper;
import cl.examen.parkingbnb.model.UsuarioModel;
import cl.examen.parkingbnb.repository.UsuarioRepository;
import cl.examen.parkingbnb.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO insert(UsuarioDTO dto) {
        UsuarioModel model = usuarioMapper.toModel(dto);
        UsuarioModel saved = usuarioRepository.save(model);
        return usuarioMapper.toDTO(saved);
    }

    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO dto) {
        UsuarioModel existing = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existing.setRut(dto.getRut());
        existing.setUsername(dto.getUsername());
        existing.setPassword(dto.getPassword());
        existing.setRol(dto.getRol());
        existing.setEmail(dto.getEmail());
        UsuarioModel updated = usuarioRepository.save(existing);
        return usuarioMapper.toDTO(updated);
    }

    @Override
    public UsuarioDTO getById(Integer id) {
        UsuarioModel model = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toDTO(model);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        List<UsuarioModel> models = usuarioRepository.findAll();
        return models.stream().map(usuarioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO delete(Integer id) {
        UsuarioModel model = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(model);
        return usuarioMapper.toDTO(model);
    }

    // Nuevo método para buscar usuario por username
    @Override
    public UsuarioDTO findByUsername(String username) {
        return usuarioRepository.findByUsername(username)
            .map(usuarioMapper::toDTO)
            .orElse(null);
    }

    // Implementación simple de login usando findByUsername
    @Override
    public UsuarioDTO login(String username, String password) {
        UsuarioDTO usuario = findByUsername(username);
        if (usuario == null || !usuario.getPassword().equals(password)) {
            return null;
        }
        return usuario;
    }
}
