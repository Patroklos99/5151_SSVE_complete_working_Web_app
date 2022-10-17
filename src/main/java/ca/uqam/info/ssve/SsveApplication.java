package ca.uqam.info.ssve;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SsveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsveApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VehicleRepository repository) {
		return args -> {
			repository.save(new Vehicle(null, "Audi", "e-tron", 4, "SUV", 86900, 357,55, 10.0, 5, "https://www.audi.ca/ca/web/en/models/etron/e-tron-quattro.html", "imgLink"));
			repository.save(new Vehicle(null, "Mitsubishi", "i-MIEV", 4, "Hatchback", 32112, 150, 1000, 10, 5, "refLink", "imgLink"));
		};
	}

}
