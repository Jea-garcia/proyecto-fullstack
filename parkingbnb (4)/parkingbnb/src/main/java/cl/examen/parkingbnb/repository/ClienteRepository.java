package cl.examen.parkingbnb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.examen.parkingbnb.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByRut(String rut);
    void deleteByRut(String rut);
}
