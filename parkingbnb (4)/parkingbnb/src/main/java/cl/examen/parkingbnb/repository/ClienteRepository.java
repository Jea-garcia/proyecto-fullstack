package cl.examen.parkingbnb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import cl.examen.parkingbnb.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, String> {
}
