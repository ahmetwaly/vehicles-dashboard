package se.alten.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGateway {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ZuulApiGateway.class);
		springApplication.addListeners(new ApplicationPidFileWriter("process.pid"));
		springApplication.run(args);
	}
}
