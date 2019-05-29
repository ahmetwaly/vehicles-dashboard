package customervehiclesmanager;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import se.alten.customervehiclemanager.CustomerVehicleManager;
import se.alten.customervehiclemanager.applicationservice.Customer;
import se.alten.customervehiclemanager.applicationservice.CustomerVehiclesService;
import se.alten.customervehiclemanager.applicationservice.Vehicle;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerVehicleManager.class)
@AutoConfigureMockMvc
@ActiveProfiles("development")
public class CustomerVehiclesManagerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CustomerVehiclesService customerVehiclesService;

	@Test
	public void testFindAllCustomersVehicles_Success() throws Exception {
		Vehicle vehicle = new Vehicle();
		vehicle.setCustomerId(1);
		vehicle.setRegNumber("GHI789");
		vehicle.setVehicleId("VLUR4X20009048066");
		vehicle.setStatus("DISCONNECTED");

		Customer customer = new Customer();
		customer.setAddress("Cementvägen 8");
		customer.setId(1);
		customer.setName("Kalles Grustransporter AB");
		customer.getVehicles().add(vehicle);
		List <Customer> customerList= new ArrayList<Customer>();
		customerList.add(customer) ;
		when(customerVehiclesService.getCustomerVehicles()).thenReturn(customerList);
		mockMvc.perform(get("/customervehicles")).andExpect(status().isOk()).andExpect(content().json(
				"[{id:1,name:\"Kalles Grustransporter AB\",address:\"Cementvägen 8\",vehicles:[{regNumber:\"GHI789\",vehicleId:\"VLUR4X20009048066\",status:\"DISCONNECTED\"}]}]"));
	}

	
	@Test
	public void testFindCustomers_When_General_Error_Then_500_Error_Code() throws Exception {
		doThrow(new RuntimeException()).when(customerVehiclesService).getCustomerVehicles();
		mockMvc.perform(get("/customervehicles")).andExpect(status().isInternalServerError());
	}

}