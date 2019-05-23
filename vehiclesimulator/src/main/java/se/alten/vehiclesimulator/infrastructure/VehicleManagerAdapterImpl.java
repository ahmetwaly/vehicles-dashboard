package se.alten.vehiclesimulator.infrastructure;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class VehicleManagerAdapterImpl implements VehicleManagerAdapter {

	@Autowired
	RestTemplate restTemplate;

	@Value("${vehiclemanager.url}")
	String vehicleManagerUrl;

	private static final Logger logger = LogManager.getLogger(VehicleManagerAdapterImpl.class);

	@Override
	public void updateVechileStatus(String vehicleId, String status)  {
		try {
			  VehicleStatusUpdateRequestDto requestDto = new VehicleStatusUpdateRequestDto(status);
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<VehicleStatusUpdateRequestDto> entity = new HttpEntity<VehicleStatusUpdateRequestDto>(requestDto,headers);
		      String response = restTemplate.exchange(
		    		  vehicleManagerUrl+vehicleId, HttpMethod.PATCH, entity, String.class).getBody();
		      logger.info(response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
