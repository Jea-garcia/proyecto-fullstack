package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.examen.parkingbnb.model.ComunaModel;

public interface ComunaRepository extends JpaRepository<ComunaModel, Long> {
}
