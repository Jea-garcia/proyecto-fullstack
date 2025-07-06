package cl.examen.parkingbnb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.examen.parkingbnb.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Optional<UsuarioModel> findByUsername(String username);
}
