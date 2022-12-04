package java.ca.uqam.info.ssve.repository;

import java.ca.uqam.info.ssve.model.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
