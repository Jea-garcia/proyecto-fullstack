package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.examen.parkingbnb.model.EstacionamientoModel;

@Repository
public interface EstacionamientoRepository extends JpaRepository<EstacionamientoModel, Long> {
}