package ca.uqam.info.ssve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@SpringBootApplication
public class SsveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsveApplication.class, args);
	}

}
