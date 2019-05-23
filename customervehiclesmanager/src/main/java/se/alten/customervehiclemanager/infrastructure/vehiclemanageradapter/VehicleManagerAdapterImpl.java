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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenWeatherMapAdapterImpl.
 */
@Component
public class VehicleManagerAdapterImpl implements VehicleManagerAdapter {

	@Autowired
	RestTemplate restTemplate;

	@Value("${vehiclemanager.url}")
	String vehicleManagerUrl;

	private static final Logger logger = LogManager.getLogger(VehicleManagerAdapterImpl.class);

	@Override
	public List<VehicleDto> getAllVehicles() {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			List<VehicleDto> vehicleDtos = restTemplate.exchange(vehicleManagerUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<VehicleDto>>() {
					}).getBody();
			return vehicleDtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}