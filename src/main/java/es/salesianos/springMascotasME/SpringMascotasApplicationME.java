package es.salesianos.springMascotasME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "es.salesianos.*" })
public class SpringMascotasApplicationME {

	public static void main(String[] args) {
		SpringApplication.run(SpringMascotasApplicationME.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringMascotasApplicationME.class);
	}
}
