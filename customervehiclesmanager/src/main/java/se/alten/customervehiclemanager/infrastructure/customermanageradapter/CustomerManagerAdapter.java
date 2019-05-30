package se.alten.customervehiclemanager.infrastructure.customermanageradapter;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import se.alten.customervehiclemanager.dto.Customer;


@Component
public class CustomerManagerAdapter {

	@Autowired
	RestTemplate restTemplate;

	@Value("${customermanager.url}")
	String customerManagerUrl;

	private static final Logger logger = LogManager.getLogger(CustomerManagerAdapter.class);

	public List<Customer> getAllCustomers() {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			System.out.println(customerManagerUrl);
			List<Customer> customerDtos = restTemplate.exchange(customerManagerUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Customer>>() {
					}).getBody();
			return customerDtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
