package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class VehicleServiceTest {

    @InjectMocks
    VehicleService vehicleService;

    @Mock
    VehicleRepository vehicleRepository;

    @BeforeEach
    public void setUp() {
        Vehicle v = new Vehicle("Audi", "e-tron", 4, "SUV", 87342, 364,95, 5, "https://www.audi.ca/ca/web/en/models/etron/e-tron-quattro.html", "imgLink");
        v.setId(1L);
        lenient().when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(v));
    }


    public Vehicle setUpTestVehicle() {
        Vehicle vehicleTest = new Vehicle();
        vehicleTest.setId(1L);
        vehicleTest.setBrand("audi");
        vehicleTest.setModelName("e-tron");
        vehicleTest.setNbDoors(4);
        vehicleTest.setType("SUV");
        vehicleTest.setPrice(87342);
        vehicleTest.setRange(364);
        vehicleTest.setBatteryCapacity(95);
        vehicleTest.setSafetyScore(5);
        vehicleTest.setRefLink("https://www.audi.ca/ca/web/en/models/etron/e-tron-quattro.html");
        vehicleTest.setImgLink("imgLink");
        return vehicleTest;
    }

    public boolean isEqual(Vehicle vehicle, Vehicle vehicleTest) {
        if (!vehicle.getId().equals(vehicleTest.getId())) {
            return false;
        } else if (!vehicle.getModelName().equals(vehicleTest.getModelName())) {
            return false;
        } else if (vehicle.getNbDoors() != vehicleTest.getNbDoors()) {
            return false;
        } else if (!vehicle.getType().equals(vehicleTest.getType())) {
            return false;
        } else if (vehicle.getPrice() != vehicleTest.getPrice()) {
            return false;
        } else if (vehicle.getRange() != vehicleTest.getRange()) {
            return false;
        } else if (vehicle.getBatteryCapacity() != vehicleTest.getBatteryCapacity()) {
            return false;
        } else if (vehicle.getSafetyScore() != vehicleTest.getSafetyScore()) {
            return false;
        } else if (!vehicle.getRefLink().equals(vehicleTest.getRefLink())) {
            return false;
        } else if (!vehicle.getImgLink().equals(vehicleTest.getImgLink())) {
            return false;
        }
        return true;
    }

    @Test
    public void testFindVehicleById() {
        Vehicle vehicle = vehicleService.getVehicle(1L);
        Vehicle vehicleTest = setUpTestVehicle();

        assertTrue(isEqual(vehicle, vehicleTest));
    }
}
