package se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter;

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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import se.alten.customervehiclemanager.dto.Vehicle;

@Component
public class  VehicleManagerAdapter {

	@Autowired
	RestTemplate restTemplate;

	@Value("${vehiclemanager.url}")
	String vehicleManagerUrl;

	private static final Logger logger = LogManager.getLogger(VehicleManagerAdapter.class);
	public List<Vehicle> getAllVehicles() {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			ResponseEntity<List<Vehicle>>  reposne=restTemplate.exchange(vehicleManagerUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Vehicle>>() {
					});
			List<Vehicle> vehicleDtos = reposne.getBody();
			return vehicleDtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
