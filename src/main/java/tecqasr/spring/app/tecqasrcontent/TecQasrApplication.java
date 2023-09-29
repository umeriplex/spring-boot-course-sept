package tecqasr.spring.app.tecqasrcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TecQasrApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TecQasrApplication.class, args);

	}

}
