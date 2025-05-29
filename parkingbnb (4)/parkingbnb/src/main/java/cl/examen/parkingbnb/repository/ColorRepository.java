package cl.examen.parkingbnb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.examen.parkingbnb.model.ColorModel;

@Repository
public interface ColorRepository extends CrudRepository<ColorModel, Integer> {
    
}