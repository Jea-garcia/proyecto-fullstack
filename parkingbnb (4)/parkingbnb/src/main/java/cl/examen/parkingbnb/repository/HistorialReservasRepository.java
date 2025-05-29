package cl.examen.parkingbnb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.examen.parkingbnb.model.HistorialReservasModel;

@Repository
public interface HistorialReservasRepository extends CrudRepository<HistorialReservasModel, Long> {
}
