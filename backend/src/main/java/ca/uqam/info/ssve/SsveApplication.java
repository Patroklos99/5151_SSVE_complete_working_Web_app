package ca.uqam.info.ssve;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SsveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsveApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Bean
	CommandLineRunner commandLineRunner(VehicleRepository repository) {
		return args -> {
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
					"src/main/resources/images/audiETron.png",
					"L'Audi e-tron offre amplement d'espace intérieur pour les déplacements quotidiens, une excellente autonomie ainsi que la performance de la traction intégrale quattro."));

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
					"src/main/resources/images/bmwI4.png",
					"Les modèles BMW i sont l'avenir de la mobilité. Créé en 2010, BMW i travaille sur des véhicules à propulsion tout électrique et partiellement électrique, mais aussi sur une nouvelle compréhension de la relation entre l'automobile et la durabilité."));

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
					"src/main/resources/images/chevreletBoltEV.png",
					"Citroën ë-C4 Électrique affiche les mêmes caractéristiques que la version thermique. Son design, son confort et sa praticité à bord sont absolument identiques. En ville, Citroën ë-C4 Électrique permet l'accès aux zones à circulation restreinte."));

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
					"src/main/resources/images/citroenEC4.png",
					"Une nouvelle ère de véhicules entièrement électriques abordables est arrivée et la voiture électrique Bolt EV de Chevrolet mène la charge. Elle offre un rendement exceptionnel, une technologie de pointe et un style exaltant."));

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
					"src/main/resources/images/fordMustangMachE.png",
					"Inspirée par la passion qu'évoque son héritage légendaire, la Mustang Mach-E est le nouveau symbole de la liberté. Préparez-vous à vibrer au rythme de l'accélération fulgurante de ce pot d'échappement zéro émission."));

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
					"src/main/resources/images/hyundaiIoniq5.png",
					"L'IONIQ 5 superbement pensée et dessinée établit une nouvelle norme pour notre gamme de véhicules électriques. Chaque détail a été conçu à partir des dernières avancées en matière de technologie et de design."));

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
					"src/main/resources/images/hyundaiKonaElectric.png",
					"Avec son design dynamique, une autonomie de batterie étonnante et une foule d'innovations technologiques, le nouveau KONA électrique comble toutes les attentes de ceux qui souhaitent profiter des avantages impressionnants de ce véhicule."));

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
					"src/main/resources/images/jaguarIpace.png",
					"Élégant et aérodynamique. Le résultat spectaculaire de l'ADN de Jaguar, de la technologie de course FIA de Formule E et du design britannique contemporain."));

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
					"src/main/resources/images/kiaENiro.png",
					"La conduite électrique en toute liberté. Offrant une autonomie maximale de 385 km, le Niro EV est tout aussi confortable et capable qu'un multisegment ordinaire, tandis que la conduite entièrement électrique vous mène à destination en toute liberté."));

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
					"src/main/resources/images/kiaESoul.png",
					"Dessinée pour faire tourner les têtes. Conçue pour transformer les esprits. La Soul EV est faite pour tous ceux qui veulent avoir du plaisir en conduisant et partir à l'aventure de la façon la plus évoluée qui soit."));

			repository.save(new Vehicle(
					"Nissan",
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
					"src/main/resources/images/nissanLeaf.png",
					"La technologie de pointe est au cœur même de la Nissan LEAF 2023, y compris une série complète de caractéristiques Nissan Intelligent Mobility(MC) conçues pour améliorer votre conduite."));

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
					"src/main/resources/images/mitsubishiIMiev.png",
					"Nous avons affiné chaque aspect de notre véhicule rechargeable le plus vendu pour créer quelque chose de vraiment remarquable. Le tout nouveau i-MIEV 2023 offre plus de puissance, une meilleure efficacité et une plus grande autonomie."));

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
					"src/main/resources/images/peugeotIOn.png",
					"La gamme électrique PEUGEOT conjugue à la fois un design innovant, des performances écologiques remarquables et des technologies de pointe."));

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
					"src/main/resources/images/peugeotPartnerTepeeElectric.png",
					"La gamme électrique PEUGEOT conjugue à la fois un design innovant, des performances écologiques remarquables et des technologies de pointe."));

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
					"src/main/resources/images/renaultZoe.png",
					"Retrouvez tout ce qui fait le succès de Zoe E-Tech 100% electric, caractère affirmé, lignes fluides, signature lumineuse à LED en forme de C."));

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
					"src/main/resources/images/smartForTwo.png",
					"Chez smart, votre sécurité est notre priorité numéro un. À tout moment, vous pouvez vérifier si votre véhicule fait l'objet de rappels et savoir quelles sont les mesures à prendre pour résoudre le problème."));

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
					"src/main/resources/images/smartForFour.png",
					"Chez smart, votre sécurité est notre priorité numéro un. À tout moment, vous pouvez vérifier si votre véhicule fait l'objet de rappels et savoir quelles sont les mesures à prendre pour résoudre le problème."));

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
					"src/main/resources/images/teslaModelS.png",
					"La Model S Plaid offre l'accélération la plus rapide de tous les véhicules en production. L'architecture de batterie mise à jour pour toutes les Model S permet de faire des tours de piste consécutifs sans perte de performance."));

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
					"src/main/resources/images/teslaModelX.png",
					"Avec la puissance inégalée et l'accélération la plus rapide de tous les VUS, le Model X Plaid est le VUS le plus performant jamais construit."));

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
					"src/main/resources/images/teslaModel3.png",
					"La Model 3 propose en option la traction intégrale à double moteur, des roues Überturbine de 20 po et des freins Performance pour une maîtrise totale en toute condition."));

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
					"src/main/resources/images/toyotaMirai.png",
					"Voici la Mirai 2022. La deuxième génération du véhicule électrique à pile à combustible à hydrogène révolutionnaire de Toyota offre plus de tout que jamais. Plus de style. Plus d'espace. Plus de technologies intelligentes et intuitives."));

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
					"src/main/resources/images/volkswagenEUp.png",
					"Plus d'autonomie que jamais. Plus d'équipements à un meilleur prix. Pour tous ceux qui évoluent avec leur temps : l'e-up! facilite encore plus l'éléctro-mobilité. Et même mieux."));

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
					"src/main/resources/images/volkswagenEGolf.png",
					"La Golf est là. La huitième génération du modèle emblématique Volkswagen établit de nouvelles normes en matière d'innovations, de confort et de connectivité."));

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
					"src/main/resources/images/volkswagenGolf.png",
					"La Golf est là. La huitième génération du modèle emblématique Volkswagen établit de nouvelles normes en matière d'innovations, de confort et de connectivité."));

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
					"src/main/resources/images/volkswagenGolf.png",
					""));
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
					"src/main/resources/images/volkswagenGolf.png",
					""));
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
					"src/main/resources/images/volkswagenGolf.png",
					""));

			// repository.save(new Vehicle(
			// "voiture",
			// "Min",
			// 5,
			// "Hatchback",
			// 31495,
			// 90,
			// 90,
			// 15.0,
			// 13.0,
			// 60,
			// 6,
			// 4,
			// 5000,
			// 5,
			// "https://www.volkswagen.co.uk/en/new/golf.html",
			// "src/main/resources/images/volkswagenGolf.png",
			// ""));
			// repository.save(new Vehicle(
			// "Voiture",
			// "Moyen",
			// 5,
			// "Hatchback",
			// 31495,
			// 120,
			// 320,
			// 15.0,
			// 13.0,
			// 60,
			// 6,
			// 4,
			// 5000,
			// 5,
			// "https://www.volkswagen.co.uk/en/new/golf.html",
			// "src/main/resources/images/volkswagenGolf.png",
			// ""));
			// repository.save(new Vehicle(
			// "Voiture",
			// "Max",
			// 5,
			// "Hatchback",
			// 31495,
			// 150,
			// 550,
			// 15.0,
			// 13.0,
			// 60,
			// 6,
			// 4,
			// 5000,
			// 5,
			// "https://www.volkswagen.co.uk/en/new/golf.html",
			// "src/main/resources/images/volkswagenGolf.png",
			// ""));
		};
	}
}
