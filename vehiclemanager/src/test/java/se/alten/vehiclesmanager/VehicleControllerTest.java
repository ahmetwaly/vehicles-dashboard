package se.alten.vehiclesmanager;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import se.alten.vehiclemanager.VehicleManagerApplication;
import se.alten.vehiclemanager.applicationservice.VehicleService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VehicleManagerApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("development")
public class VehicleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@SpyBean
	VehicleService vehicleService;

	@Test
	public void testFindAllVehicles_Success() throws Exception {
		mockMvc.perform(get("/vehicles")).andExpect(status().isOk()).andExpect(content().json(
				"[{\"regNumber\":\"PQR678\",\"vehicleId\":\"VLUR4X20009011111\",\"customerId\":3,\"status\":\"DISCONNECTED\"},{\"regNumber\":\"GHI789\",\"vehicleId\":\"VLUR4X20009048066\",\"customerId\":1,\"status\":\"DISCONNECTED\"},{\"regNumber\":\"DEF456\",\"vehicleId\":\"VLUR4X20009093588\",\"customerId\":1,\"status\":\"DISCONNECTED\"},{\"regNumber\":\"STU901\",\"vehicleId\":\"YS2R4X20005387055\",\"customerId\":3,\"status\":\"DISCONNECTED\"},{\"regNumber\":\"JKL012\",\"vehicleId\":\"YS2R4X20005387949\",\"customerId\":2,\"status\":\"DISCONNECTED\"},{\"regNumber\":\"MNO345\",\"vehicleId\":\"YS2R4X20005388011\",\"customerId\":2,\"status\":\"DISCONNECTED\"},{\"regNumber\":\"ABC123\",\"vehicleId\":\"YS2R4X20005399401\",\"customerId\":1,\"status\":\"DISCONNECTED\"}]"));
	}

	@Test
	public void testVehicleById_Success() throws Exception {
		mockMvc.perform(get("/vehicles/YS2R4X20005399401")).andExpect(status().isOk()).andExpect(content().json(
				"{\"regNumber\":\"ABC123\",\"vehicleId\":\"YS2R4X20005399401\",\"customerId\":1,\"status\":\"DISCONNECTED\"}"));
	}

	@Test
	public void testFindVehicle_Invalid_Id_then_404_Error() throws Exception {
		mockMvc.perform(get("/vehicles/10")).andExpect(status().isNotFound());
	}

	@Test
	public void testFindVehicles_When_General_Error_Then_500_Error_Code() throws Exception {
		doThrow(new RuntimeException()).when(vehicleService).findAllVehicles();
		mockMvc.perform(get("/vehicles")).andExpect(status().isInternalServerError());
	}

}