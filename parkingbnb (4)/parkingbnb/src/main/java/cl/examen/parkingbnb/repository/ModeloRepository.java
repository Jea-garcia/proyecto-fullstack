package cl.examen.parkingbnb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.examen.parkingbnb.model.ModeloModel;

@Repository
public interface ModeloRepository extends CrudRepository<ModeloModel, Integer> {
}
