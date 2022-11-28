package ca.uqam.info.ssve;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@SpringBootApplication
public class SsveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsveApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VehicleRepository repository) {
		return args -> {

			/*
			 * Donnees de test
			 * 
			 * repository.save(new Vehicle("voiture", "Min", 4, "Hatchback", 31495, 90,
			 * 1000, 5, "https://www" +
			 * ".volkswagen.co.uk/en/new/golf.html",
			 * "src/main/resources/images/volkswagenGolf.png"));
			 * 
			 * repository.save(new Vehicle("Voiture", "Moyen", 4, "Hatchback", 31495, 320,
			 * 1000, 5, "https://www" +
			 * ".volkswagen.co.uk/en/new/golf.html",
			 * "src/main/resources/images/volkswagenGolf.png"));
			 * 
			 * repository.save(new Vehicle("Voiture", "Max", 4, "Hatchback", 31495, 550,
			 * 1000, 5, "https://www" +
			 * ".volkswagen.co.uk/en/new/golf.html",
			 * "src/main/resources/images/volkswagenGolf.png"));
			 * 
			 */

			repository.save(new Vehicle(
					"Audi",
					"e-tron",
					5,
					"SUV",
					87342,
					40,
					86,
					20.9,
					34.2,
					0,
					0,
					0,
					300,
					5,
					"https://www.audi.ca/ca/web/en/models/etron/e-tron-quattro.html",
					"src/main/resources/images/audiETron.png"));

			repository.save(new Vehicle(
					"BMW",
					"i4",
					5,
					"Sedan",
					54990,
					40,
					80,
					20.0,
					20.3,
					0,
					0,
					0,
					300,
					5,
					"https://www.bmw.ca/en/all-models/bmw-i/i4/2021/bmw-i4-highlights.html",
					"src/main/resources/images/bmwI4.png"));

			repository.save(new Vehicle(
					"Citroen",
					"e-C4",
					5,
					"SUV",
					34252,
					40,
					46,
					10.1,
					16.5,
					0,
					0,
					0,
					300,
					5,
					"https://www.citroen.co.uk/models/c4-e-c4.html",
					"src/main/resources/images/chevreletBoltEV.png"));

			repository.save(new Vehicle(
					"Chevrolet",
					"Bolt EV",
					5,
					"Hatchback",
					25600,
					40,
					60,
					15.7,
					15.7,
					0,
					0,
					0,
					300,
					5,
					"https://www.chevrolet.com/electric/bolt-ev",
					"src/main/resources/images/citroenEC4.png"));

			repository.save(new Vehicle(
					"Ford Mustang",
					"Mach-E",
					5,
					"SUV",
					51495,
					40,
					68,
					12.8,
					20.9,
					0,
					0,
					0,
					300,
					5,
					"https://www.ford.ca/suvs/mach-e/?gnav=header-electrified-vhp",
					"src/main/resources/images/fordMustangMachE.png"));

			repository.save(new Vehicle(
					"Hyundai",
					"Ioniq 5",
					5,
					"SUV",
					47650,
					40,
					74,
					12.2,
					21.5,
					0,
					0,
					0,
					300,
					5,
					"https://www.hyundaicanada.com/en/showroom/2022/ioniq-5",
					"src/main/resources/images/hyundaiIoniq5.png"));

			repository.save(new Vehicle(
					"Hyundai",
					"Kona Electric",
					5,
					"SUV",
					46550,
					40,
					64,
					10.7,
					18.6,
					0,
					0,
					0,
					300,
					5,
					"https://www.hyundaicanada.com/en/showroom/2022/kona-n",
					"src/main/resources/images/hyundaiKonaElectric.png"));

			repository.save(new Vehicle(
					"Jaguar",
					"I-Pace",
					5,
					"SUV",
					102800,
					40,
					84,
					17,
					25.6,
					0,
					0,
					0,
					300,
					5,
					"https://www.jaguar.ca/en/all-models/i-pace/index.html",
					"src/main/resources/images/jaguarIpace.png"));

			repository.save(new Vehicle(
					"Kia",
					"e-Niro",
					5,
					"SUV",
					47804,
					40,
					64,
					12.5,
					20.5,
					0,
					0,
					0,
					300,
					5,
					"https://www.kia.ca/en/vehicles/2022/niro-ev",
					"src/main/resources/images/kiaENiro.png"));

			repository.save(new Vehicle(
					"Kia",
					"e-Soul",
					5,
					"SUV",
					45909,
					40,
					64,
					12.2,
					19.9,
					0,
					0,
					0,
					300,
					5,
					"https://www.kia.ca/en/vehicles/2023/soul-ev",
					"src/main/resources/images/kiaESoul.png"));

			repository.save(new Vehicle(
					"Mitsubishi",
					"Leaf",
					5,
					"Hatchback",
					41560,
					40,
					14,
					10,
					10,
					0,
					0,
					0,
					300,
					5,
					"https://www.nissan.ca/vehicles/electric-cars/leaf.html",
					"src/main/resources/images/nissanLeaf.png"));

			repository.save(new Vehicle(
					"Mitsubishi",
					"i-MIEV",
					5,
					"Hatchback",
					32112,
					40,
					14,
					10,
					10,
					0,
					0,
					0,
					300,
					3,
					"https://www.mitsubishicars.com/i-miev-electric-car",
					"src/main/resources/images/mitsubishiIMiev.png"));

			repository.save(new Vehicle(
					"Peugeot",
					"iOn",
					5,
					"Hatchback",
					29426,
					40,
					13,
					12.5,
					12.5,
					0,
					0,
					0,
					300,
					5,
					"https://ev-database.org/car/1095/Peugeot-iOn",
					"src/main/resources/images/peugeotIOn.png"));

			repository.save(new Vehicle(
					"Peugeot",
					"Partner Tepee Electric",
					5,
					"Van",
					41129,
					40,
					22,
					13.5,
					22,
					0,
					0,
					0,
					300,
					5,
					"https://www.rac.co.uk/drive/car-reviews/peugeot/partner/partner-tepee-2015-2018/",
					"src/main/resources/images/peugeotPartnerTepeeElectric.png"));

			repository.save(new Vehicle(
					"Renault",
					"Zoé",
					2,
					"Hatchback",
					46959,
					40,
					52,
					13.5,
					22,
					0,
					0,
					0,
					300,
					5,
					"https://www.renault.co.uk/electric-vehicles/zoe.html",
					"src/main/resources/images/renaultZoe.png"));

			repository.save(new Vehicle(
					"Smart",
					"ForTwo Electric Drive",
					2,
					"Hatchback",
					29050,
					40,
					17,
					12.5,
					20.4,
					0,
					0,
					0,
					300,
					5,
					"https://www.caranddriver.com/smart/eq-fortwo",
					"src/main/resources/images/smartForTwo.png"));

			repository.save(new Vehicle(
					"Smart",
					"ForFour Electric Drive",
					4,
					"Hatchback",
					25808,
					40,
					17,
					13.9,
					22.8,
					0,
					0,
					0,
					300,
					5,
					"https://www.smart.mercedes-benz.com/gb/en/models/eq-forfour#intro-smart-eq-forfour",
					"src/main/resources/images/smartForFour.png"));

			repository.save(new Vehicle(
					"Tesla",
					"Model S",
					5,
					"Sedan",
					135000,
					60,
					60,
					22,
					22,
					0,
					0,
					0,
					300,
					5,
					"https://www.tesla.com/en_ca/models",
					"src/main/resources/images/teslaModelS.png"));

			repository.save(new Vehicle(
					"Tesla",
					"Model X",
					5,
					"SUV",
					156000,
					60,
					60,
					16.9,
					16.9,
					0,
					0,
					0,
					300,
					5,
					"https://www.tesla.com/en_ca/modelx",
					"src/main/resources/images/teslaModelX.png"));

			repository.save(new Vehicle(
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
					"src/main/resources/images/teslaModel3.png"));

			repository.save(new Vehicle(
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
					"src/main/resources/images/toyotaMirai.png"));

			repository.save(new Vehicle(
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
					"src/main/resources/images/volkswagenEUp.png"));

			repository.save(new Vehicle(
					"Volkswagen",
					"e-Golf",
					5,
					"Hatchback",
					43059,
					72,
					32,
					16.8,
					10.7,
					0,
					0,
					0,
					480,
					5,
					"https://www.volkswagen.co.uk/en/new/e-golf.html",
					"src/main/resources/images/volkswagenEGolf.png"));

			repository.save(new Vehicle(
					"Volkswagen",
					"Golf",
					5,
					"Hatchback",
					46000,
					72,
					0,
					0,
					0,
					45,
					6.5,
					4.6,
					645,
					5,
					"https://www.volkswagen.co.uk/en/new/golf.html",
					"src/main/resources/images/volkswagenGolf.png"));

			repository.save(new Vehicle(
					"voiture",
					"Min",
					5,
					"Hatchback",
					31495,
					90,
					100,
					15.0,
					13.0,
					60,
					6,
					4,
					5000,
					5,
					"https://www.volkswagen.co.uk/en/new/golf.html",
					"src/main/resources/images/volkswagenGolf.png"));
			repository.save(new Vehicle(
					"Voiture",
					"Moyen",
					5,
					"Hatchback",
					31495,
					120,
					100,
					15.0,
					13.0,
					60,
					6,
					4,
					5000,
					5,
					"https://www.volkswagen.co.uk/en/new/golf.html",
					"src/main/resources/images/volkswagenGolf.png"));
			repository.save(new Vehicle(
					"Voiture",
					"Max",
					5,
					"Hatchback",
					31495,
					150,
					100,
					15.0,
					13.0,
					60,
					6,
					4,
					5000,
					5,
					"https://www.volkswagen.co.uk/en/new/golf.html",
					"src/main/resources/images/volkswagenGolf.png"));
		};
	}
}
