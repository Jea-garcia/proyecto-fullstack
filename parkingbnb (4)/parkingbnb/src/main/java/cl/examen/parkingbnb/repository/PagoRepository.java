package cl.examen.parkingbnb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.examen.parkingbnb.dto.PagoDTO;
import cl.examen.parkingbnb.model.PagoModel;

@Repository
public interface PagoRepository extends CrudRepository<PagoModel, Integer> {

    PagoDTO save(PagoDTO pago);
}