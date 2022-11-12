package ca.uqam.info.ssve.repository;

import ca.uqam.info.ssve.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
