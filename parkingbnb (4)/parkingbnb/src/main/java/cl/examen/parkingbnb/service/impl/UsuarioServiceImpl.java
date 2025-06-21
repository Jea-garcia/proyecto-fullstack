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
    UsuarioRepository repositoryUsuario;

    @Override
    public UsuarioDTO save(UsuarioDTO usuario) {
        UsuarioModel model = UsuarioMapper.toModel(usuario);
        return UsuarioMapper.toDTO(repositoryUsuario.save(model));
    }

    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO usuario) {
        UsuarioModel model = UsuarioMapper.toModel(usuario);
        model.setId(id); // aseguramos que se actualice el correcto
        return UsuarioMapper.toDTO(repositoryUsuario.save(model));
    }

    @Override
    public UsuarioDTO delete(Integer id) {
        repositoryUsuario.deleteById(id);
        return null; // podrías devolver el eliminado si lo cargas antes
    }

    @Override
    public UsuarioDTO getById(Integer id) {
        return repositoryUsuario.findById(id)
                .map(UsuarioMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return repositoryUsuario.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

   @Override
public UsuarioDTO insert(UsuarioDTO usuario) {
    return save(usuario); // simplemente llama a save para insertar
}

@Override
public UsuarioDTO login(String username, String password) {
    return repositoryUsuario.findByUsername(username)
            .filter(user -> user.getPassword().equals(password)) // acá comparas la contraseña, si usas hash, cambia lógica
            .map(UsuarioMapper::toDTO)
            .orElse(null);
}
}
