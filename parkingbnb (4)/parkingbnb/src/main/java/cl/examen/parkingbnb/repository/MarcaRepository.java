package cl.examen.parkingbnb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.examen.parkingbnb.model.MarcaModel;

@Repository
public interface MarcaRepository extends CrudRepository<MarcaModel, Integer> {
}
