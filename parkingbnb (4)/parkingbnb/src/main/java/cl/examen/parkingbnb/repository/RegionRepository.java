package cl.examen.parkingbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.examen.parkingbnb.model.RegionModel;

@Repository
public interface RegionRepository extends JpaRepository<RegionModel, Integer> {
}
