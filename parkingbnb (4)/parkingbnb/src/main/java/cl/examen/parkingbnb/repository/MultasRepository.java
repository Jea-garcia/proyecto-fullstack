package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.examen.parkingbnb.model.MultasModel;

public interface MultasRepository extends JpaRepository<MultasModel, Integer> {
}