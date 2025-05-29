package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.examen.parkingbnb.model.ReservaModel;

public interface ReservaRepository extends JpaRepository<ReservaModel, Integer> {
}