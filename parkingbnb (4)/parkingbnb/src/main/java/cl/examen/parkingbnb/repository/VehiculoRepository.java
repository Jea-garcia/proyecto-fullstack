package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.examen.parkingbnb.model.VehiculoModel;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoModel, Long> {
}
