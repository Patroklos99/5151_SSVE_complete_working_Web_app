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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setModelName("Ferari");
        lenient().when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(vehicle));
        lenient().when(vehicleRepository.save(any())).thenReturn(vehicle);
    }

    @Test
    public void shouldReturnVehicleGetVehicule1L() {
        Vehicle result = vehicleService.getVehicle(1L);
        assertThat(result).isNotNull();
        assertEquals(result.getId(), 1L);
        assertEquals(result.getModelName(), "Ferari");
    }

    /**
    @Test
    public void shouldReturnVehicleSaveVehicule1L() {
        Vehicle result = vehicleService.saveVehicle(new Vehicle(1L, "Ferari"));
        assertThat(result).isNotNull();
        assertEquals(result.getId(), 1L);
        assertEquals(result.getModelName(), "Ferari");
    }*/
}
