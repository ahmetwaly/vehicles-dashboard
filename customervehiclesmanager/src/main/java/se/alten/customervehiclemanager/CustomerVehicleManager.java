package se.alten.customervehiclemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import se.alten.customervehiclemanager.applicationservice.CustomerVehiclesService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class CustomerVehicleManager  {

	@Autowired
	CustomerVehiclesService customersVehicleService;

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(CustomerVehicleManager.class);
		springApplication.addListeners(new ApplicationPidFileWriter("process.pid"));
		springApplication.run(args);
	}

	@Bean
	public  RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		return new RestTemplate(requestFactory);
	}

}
