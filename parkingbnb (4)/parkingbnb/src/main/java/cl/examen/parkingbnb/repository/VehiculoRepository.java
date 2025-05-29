package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.examen.parkingbnb.model.VehiculoModel;

public interface VehiculoRepository extends JpaRepository<VehiculoModel, String> {
}