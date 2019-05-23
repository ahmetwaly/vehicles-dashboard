package se.alten.customermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
public class CustomerManager {
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(CustomerManager.class);
		springApplication.addListeners(new ApplicationPidFileWriter("process.pid"));
		springApplication.run(args);
	}

}
