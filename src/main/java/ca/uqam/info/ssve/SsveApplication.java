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
			//repository.save(new Vehicle(null, "brand", "name", 4, "type", 99999, 999, 9999, -1, -1, "refLink", "imgLink"));
			repository.save(new Vehicle("Audi", "e-tron", 4, "SUV", 87342, 364,95, 5, "https://www.audi.ca/ca/web/en/models/etron/e-tron-quattro.html", "imgLink"));
			repository.save(new Vehicle("BMW", "i4", 4, "Sedan", 54990, 484, 84, 4, "https://www.bmw.ca/en/all-models/bmw-i/i4/2021/bmw-i4-highlights.html", "imgLink"));
			repository.save(new Vehicle("Citroen", "e-C4", 4, "SUV", 34252, 352, 50, 4, "https://www.citroen.co.uk/models/c4-e-c4.html", "imgLink"));
			repository.save(new Vehicle("Chevrolet", "Bolt EV", 4, "Hatchback", 25600, 417, 65, 5, "https://www.chevrolet.com/electric/bolt-ev", "imgLink"));
			repository.save(new Vehicle("Ford Mustang", "Mach-E", 4, "SUV", 51495, 418, 70, -1, "https://www.ford.ca/suvs/mach-e/?gnav=header-electrified-vhp", "imgLink"));
			repository.save(new Vehicle("Hyundai", "Ioniq 5", 4, "SUV", 47650, 354, 58, -1, "https://www.hyundaicanada.com/en/showroom/2022/ioniq-5", "imgLink"));
			repository.save(new Vehicle("Hyundai", "Kona Electric", 4, "SUV", 46550, 415, 64, 5, "https://www.hyundaicanada.com/en/showroom/2022/kona-n", "imgLink"));
			repository.save(new Vehicle("Jaguar", "I-Pace", 4, "SUV", 102800, 381, 90, 5, "https://www.jaguar.ca/en/all-models/i-pace/index.html", "imgLink"));
			repository.save(new Vehicle("Kia", "e-Niro", 4, "SUV", 47804, 385, 64, 5, "https://www.kia.ca/en/vehicles/2022/niro-ev", "imgLink"));
			repository.save(new Vehicle("Kia", "e-Soul", 4, "SUV", 45909, 248, 40, 4, "https://www.kia.ca/en/vehicles/2023/soul-ev", "imgLink"));
			repository.save(new Vehicle("Nissan", "Leaf", 4, "Hatchback", 41560, 342, 40, 5, "https://www.nissan.ca/vehicles/electric-cars/leaf.html", "imgLink"));
			repository.save(new Vehicle("Mitsubishi", "i-MIEV", 4, "Hatchback", 32112, 150, 1000, 5, "refLink", "imgLink"));
			repository.save(new Vehicle("Peugeot", "iOn", 4, "Hatchback", 29426, 100, 1000, 5, "refLink", "imgLink"));
			repository.save(new Vehicle("Peugeot", "Partner Tepee Electric", 4, "Van", 41129, 170, 1000, 5, "refLink", "imgLink"));
			repository.save(new Vehicle("Renault", "Zoé", 2, "Hatchback", 46959, 395, 1000, 5, "refLink", "imgLink"));
			repository.save(new Vehicle("Smart", "ForTwo Electric Drive", 2, "Hatchback", 29050, 169, 1000, 5, "refLink", "imgLink"));
			repository.save(new Vehicle("Smart", "ForFour Electric Drive", 4, "Hatchback", 25808, 153, 1000, 5, "refLink", "imgLink"));
			repository.save(new Vehicle("Tesla", "Model", 4, "Sedan", 135000, 604, 1000, 5, "refLink", "imgLink"));
		};
	}

}
