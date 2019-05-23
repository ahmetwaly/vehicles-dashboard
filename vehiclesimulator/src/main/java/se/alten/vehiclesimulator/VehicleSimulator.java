package se.alten.vehiclesimulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import se.alten.vehiclesimulator.applicationservice.VehicleSimulatorService;

@SpringBootApplication
@EnableJpaRepositories
public class VehicleSimulator implements CommandLineRunner {

	@Autowired
	VehicleSimulatorService vehicleSimulatorService;

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(VehicleSimulator.class);
		springApplication.addListeners(new ApplicationPidFileWriter("process.pid"));
		springApplication.run(args);
	}


	@Bean
	public  RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		return new RestTemplate(requestFactory);
	}

	@Override
	public void run(String... args) throws Exception {
		vehicleSimulatorService.updateServiceStatus();

	}

}
