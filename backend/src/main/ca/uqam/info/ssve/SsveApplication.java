package ca.uqam.info.ssve;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
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
			//repository.save(new Vehicle( "brand", "modelName", nbDoors, "type", price, range, batteryCapacity,
					//safetyScore, "refLink", "imgLink"));
			repository.save(new Vehicle("Audi", "e-tron", 4, "SUV", 87342, 364,95, 5, "https://www.audi" +
					".ca/ca/web/en/models/etron/e-tron-quattro.html", "src/main/resources/images/audiETron.png"));
			repository.save(new Vehicle("BMW", "i4", 4, "Sedan", 54990, 484, 84, 4, "https://www.bmw" +
					".ca/en/all-models/bmw-i/i4/2021/bmw-i4-highlights.html", "src/main/resources/images/bmwI4.png"));
			repository.save(new Vehicle("Citroen", "e-C4", 4, "SUV", 34252, 352, 50, 4, "https://www.citroen.co" +
					".uk/models/c4-e-c4.html", "src/main/resources/images/chevreletBoltEV.png"));
			repository.save(new Vehicle("Chevrolet", "Bolt EV", 4, "Hatchback", 256, 417000, 65, 5, "https://www" +
					".chevrolet.com/electric/bolt-ev", "src/main/resources/images/citroenEC4.png"));
			repository.save(new Vehicle("Ford Mustang", "Mach-E", 4, "SUV", 51495, 418, 70, -1, "https://www.ford" +
					".ca/suvs/mach-e/?gnav=header-electrified-vhp", "src/main/resources/images/fordMustangMachE.png"));
			/*repository.save(new Vehicle("Hyundai", "Ioniq 5", 4, "SUV", 47650, 354000, 58, -1, "https://www" +
					".hyundaicanada.com/en/showroom/2022/ioniq-5", "src/main/resources/images/hyundaiIoniq5.png"));
			repository.save(new Vehicle("Hyundai", "Kona Electric", 4, "SUV", 46550, 415000, 64, 5, "https://www" +
					".hyundaicanada.com/en/showroom/2022/kona-n", "src/main/resources/images/hyundaiKonaElectric.png"));
			repository.save(new Vehicle("Jaguar", "I-Pace", 4, "SUV", 102800, 381000, 90, 5, "https://www.jaguar" +
					".ca/en/all-models/i-pace/index.html", "src/main/resources/images/jaguarIpace.png"));
			repository.save(new Vehicle("Kia", "e-Niro", 4, "SUV", 47804, 385000, 64, 5, "https://www.kia" +
					".ca/en/vehicles/2022/niro-ev", "src/main/resources/images/kiaENiro.png"));
			repository.save(new Vehicle("Kia", "e-Soul", 4, "SUV", 45909, 248000, 40, 4, "https://www.kia" +
					".ca/en/vehicles/2023/soul-ev", "src/main/resources/images/kiaESoul.png"));
			repository.save(new Vehicle("Nissan", "Leaf", 4, "Hatchback", 41560, 342000, 40, 5, "https://www.nissan" +
					".ca/vehicles/electric-cars/leaf.html", "src/main/resources/images/mitsubishiIMiev.png"));
			repository.save(new Vehicle("Mitsubishi", "i-MIEV", 4, "Hatchback", 32112, 150000, 1000, 5, "https://www" +
					".mitsubishicars.com/i-miev-electric-car", "src/main/resources/images/nissanLeaf.png"));
			repository.save(new Vehicle("Peugeot", "iOn", 4, "Hatchback", 29426, 100000, 1000, 5, "https://ev" +
					"-database.org/car/1095/Peugeot-iOn", "src/main/resources/images/peugeotIOn.png"));
			repository.save(new Vehicle("Peugeot", "Partner Tepee Electric", 4, "Van", 41129, 170000, 1000, 5, "https" +
					"://www.rac.co.uk/drive/car-reviews/peugeot/partner/partner-tepee-2015-2018/", "src/main/resources/images/peugeotPartnerTepeeElectric.png"));
			repository.save(new Vehicle("Renault", "Zoé", 2, "Hatchback", 46959, 395000, 1000, 5, "https://www" +
					".renault.co.uk/electric-vehicles/zoe.html", "src/main/resources/images/renaultZoe.png"));
			repository.save(new Vehicle("Smart", "ForTwo Electric Drive", 2, "Hatchback", 29050, 169000, 1000, 5,
					"https://www.caranddriver.com/smart/eq-fortwo", "src/main/resources/images/smartForTwo.png"));
			repository.save(new Vehicle("Smart", "ForFour Electric Drive", 4, "Hatchback", 25808, 153000, 1000, 5,
					"https://www.smart.mercedes-benz.com/gb/en/models/eq-forfour#intro-smart-eq-forfour", "src/main/resources/images/smartForFour.png"));
			repository.save(new Vehicle("Tesla", "Model S", 4, "Sedan", 135000, 550000, 1000, 5, "https://www.tesla" +
					".com/en_ca/models", "src/main/resources/images/teslaModelS.png"));
			repository.save(new Vehicle("Tesla", "Model X", 4, "SUV", 156000, 534000, 1000, 5, "https://www.tesla" +
					".com/en_ca/modelx", "src/main/resources/images/teslaModelX.png"));
			repository.save(new Vehicle("Tesla", "Model 3", 5, "Sedan", 59990, 430000, 1000, 5, "https://www.tesla" +
					".com/en_ca/model3", "src/main/resources/images/teslaModel3.png"));
			repository.save(new Vehicle("Toyota", "Mirai", 4, "Sedan", 54990, 550000, 1000, 5, "https://www.toyota" +
					".com/mirai/", "src/main/resources/images/toyotaMirai.png"));
			repository.save(new Vehicle("Volkswagen", "e-up!", 4, "Hatchback", 34892, 256000, 1000, 5, "https://www" +
					".volkswagen.co.uk/en/new/e-up.html", "src/main/resources/images/volkswagenEUp.png"));
			repository.save(new Vehicle("Volkswagen", "e-Golf", 4, "Hatchback", 43059, 232000, 1000, 5, "https://www" +
					".volkswagen.co.uk/en/new/e-golf.html", "src/main/resources/images/volkswagenEGolf.png"));
			repository.save(new Vehicle("Volkswagen", "Golf", 4, "Hatchback", 31495, 250000, 1000, 5, "https://www" +
					".volkswagen.co.uk/en/new/golf.html", "src/main/resources/images/volkswagenGolf.png"));*/
//			repository.save(new Vehicle("voiture", "Min", 4, "Hatchback", 31495, 90, 1000, 5, "https://www" +
//					".volkswagen.co.uk/en/new/golf.html", "src/main/resources/images/volkswagenGolf.png"));
//			repository.save(new Vehicle("Voiture", "Moyen", 4, "Hatchback", 31495, 320, 1000, 5, "https://www" +
//					".volkswagen.co.uk/en/new/golf.html", "src/main/resources/images/volkswagenGolf.png"));
//			repository.save(new Vehicle("Voiture", "Max", 4, "Hatchback", 31495, 550, 1000, 5, "https://www" +
//					".volkswagen.co.uk/en/new/golf.html", "src/main/resources/images/volkswagenGolf.png"));
		};
	}

}
