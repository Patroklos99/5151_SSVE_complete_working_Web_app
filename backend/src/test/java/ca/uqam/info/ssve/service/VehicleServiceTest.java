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
                vehicleRepository.save(new Vehicle(
                                "Tesla",
                                "Model 3",
                                5,
                                "Sedan",
                                59990,
                                40,
                                50,
                                12,
                                12,
                                0,
                                0,
                                0,
                                300,
                                5,
                                "https://www.tesla.com/en_ca/model3",
                                "src/main/resources/images/teslaModel3.png",
                                "La Model 3 propose en option la traction intégrale à double moteur, des roues Überturbine de 20 po et des freins Performance pour une maîtrise totale en toute condition."));

                vehicleRepository.save(new Vehicle(
                                "Toyota",
                                "Mirai",
                                5,
                                "Sedan",
                                54990,
                                72,
                                0,
                                0,
                                0,
                                142,
                                7,
                                8,
                                480,
                                5,
                                "https://www.toyota.com/mirai/",
                                "src/main/resources/images/toyotaMirai.png",
                                "Voici la Mirai 2022. La deuxième génération du véhicule électrique à pile à combustible à hydrogène révolutionnaire de Toyota offre plus de tout que jamais. Plus de style. Plus d'espace. Plus de technologies intelligentes et intuitives."));

                vehicleRepository.save(new Vehicle(
                                "Volkswagen",
                                "e-Up",
                                5,
                                "Hatchback",
                                35417,
                                72,
                                32,
                                13.5,
                                10.7,
                                0,
                                0,
                                0,
                                480,
                                5,
                                "https://www.volkswagen.co.uk/en/new/e-up.html",
                                "src/main/resources/images/volkswagenEUp.png",
                                "Plus d'autonomie que jamais. Plus d'équipements à un meilleur prix. Pour tous ceux qui évoluent avec leur temps : l'e-up! facilite encore plus l'éléctro-mobilité. Et même mieux."));
        }

        public Vehicle setUpTestVehicle() {
                Vehicle vehicleTest = new Vehicle();
                vehicleTest.setId(1L);
                vehicleTest.setBrand("Volkswagen");
                vehicleTest.setModelName("e-Up");
                vehicleTest.setNbPlaces(5);
                vehicleTest.setType("Hatchback");
                vehicleTest.setPrice(35417);
                vehicleTest.setMaintainCosts(72);
                vehicleTest.setElectricalCapacity(32);
                vehicleTest.setElectricalStreetConsumption(13.5);
                vehicleTest.setElectricalHighwayConsumption(10.7);
                vehicleTest.setGasCapacity(0);
                vehicleTest.setGasStreetConsumption(0);
                vehicleTest.setGasHighwayConsumption(0);
                vehicleTest.setLoadCapacity(480);
                vehicleTest.setSafetyScore(5);
                vehicleTest.setRefLink("https://www.volkswagen.co.uk/en/new/e-up.html");
                vehicleTest.setImgLink("src/main/resources/images/volkswagenEUp.png");
                vehicleTest.setDescription(
                                "Plus d'autonomie que jamais. Plus d'équipements à un meilleur prix. Pour tous ceux qui évoluent avec leur temps : l'e-up! facilite encore plus l'éléctro-mobilité. Et même mieux.");
                return vehicleTest;
        }

        public boolean isEqual(Vehicle vehicle, Vehicle vehicleTest) {
                return vehicle.getId().equals(vehicleTest.getId()) &&
                                vehicle.getBrand().equals(vehicleTest.getBrand()) &&
                                vehicle.getModelName().equals(vehicleTest.getModelName()) &&
                                vehicle.getNbPlaces() == vehicleTest.getNbPlaces() &&
                                vehicle.getType().equals(vehicleTest.getType()) &&
                                vehicle.getPrice() == vehicleTest.getPrice() &&
                                vehicle.getMaintainCosts() == vehicleTest.getMaintainCosts() &&
                                vehicle.getElectricalCapacity() == vehicleTest.getElectricalCapacity() &&
                                vehicle.getElectricalStreetConsumption() == vehicleTest.getElectricalStreetConsumption()
                                &&
                                vehicle.getElectricalHighwayConsumption() == vehicleTest
                                                .getElectricalStreetConsumption()
                                &&
                                vehicle.getGasCapacity() == vehicleTest.getGasCapacity() &&
                                vehicle.getGasStreetConsumption() == vehicleTest.getGasStreetConsumption() &&
                                vehicle.getGasHighwayConsumption() == vehicleTest.getGasHighwayConsumption() &&
                                vehicle.getLoadCapacity() == vehicleTest.getLoadCapacity() &&
                                vehicle.getSafetyScore() == vehicleTest.getSafetyScore() &&
                                vehicle.getRefLink().equals(vehicleTest.getRefLink()) &&
                                vehicle.getImgLink().equals(vehicleTest.getImgLink()) &&
                                vehicle.getDescription().equals(vehicleTest.getDescription());
        }

        @Test
        public void testFindVehicleById() {
                Vehicle vehicle = vehicleService.getVehicle(1L);
                Vehicle vehicleTest = setUpTestVehicle();

                assertTrue(isEqual(vehicle, vehicleTest));
        }

        @Test
        public void testEvaluateVehicle() {

        }
}
