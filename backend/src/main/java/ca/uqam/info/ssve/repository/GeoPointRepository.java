package ca.uqam.info.ssve.repository;

import ca.uqam.info.ssve.model.GeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoPointRepository extends JpaRepository<GeoPoint, Long> {

}