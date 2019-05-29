package customervehiclesmanager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se.alten.customervehiclemanager.applicationservice.Customer;
import se.alten.customervehiclemanager.applicationservice.CustomerVehiclesService;
import se.alten.customervehiclemanager.infrastructure.customermanageradapter.CustomerDto;
import se.alten.customervehiclemanager.infrastructure.customermanageradapter.CustomerManagerAdapter;
import se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter.VehicleDto;
import se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter.VehicleManagerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerVehiclesServiceTest {

	@Mock
	VehicleManagerAdapter vehicleManagerAdapter ;
	
	@Mock
	CustomerManagerAdapter customerManagerAdapter ;
	
	@InjectMocks
	
	@Spy
	CustomerVehiclesService customerVehiclesService ;
	
	@Test
	public void testGetCustomerVehicles_Success () {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setCustomerId(1);
		vehicle.setRegNumber("GHI789");
		vehicle.setVehicleId("VLUR4X20009048066");
		vehicle.setStatus("DISCONNECTED");

		CustomerDto customer = new CustomerDto();
		customer.setAddress("Cementvägen 8");
		customer.setId(1);
		customer.setName("Kalles Grustransporter AB");
		
		when(vehicleManagerAdapter.getAllVehicles()).thenReturn(Arrays.asList(vehicle));
		when(customerManagerAdapter.getAllCustomers()).thenReturn(Arrays.asList(customer));
		List<Customer> customerList = customerVehiclesService.getCustomerVehicles();
		assertEquals(customerList.get(0).getId(), customer.getId());
		assertEquals(customerList.get(0).getAddress(), customer.getAddress());
		assertEquals(customerList.get(0).getName(), customer.getName());
		assertEquals(customerList.get(0).getVehicles().get(0).getCustomerId(), vehicle.getCustomerId());
		assertEquals(customerList.get(0).getVehicles().get(0).getRegNumber(), vehicle.getRegNumber());
		assertEquals(customerList.get(0).getVehicles().get(0).getStatus(), vehicle.getStatus());
		assertEquals(customerList.get(0).getVehicles().get(0).getVehicleId(), vehicle.getVehicleId());		
		
	}
	@Test
	public void testGetCustomerVehicles_GetCustomerSucces_GetVehiclesFail_Then_Retrun_Customers () {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setCustomerId(1);
		vehicle.setRegNumber("GHI789");
		vehicle.setVehicleId("VLUR4X20009048066");
		vehicle.setStatus("DISCONNECTED");

		CustomerDto customer = new CustomerDto();
		customer.setAddress("Cementvägen 8");
		customer.setId(1);
		customer.setName("Kalles Grustransporter AB");
		
		when(vehicleManagerAdapter.getAllVehicles()).thenReturn(null);
		when(customerManagerAdapter.getAllCustomers()).thenReturn(Arrays.asList(customer));
		List<Customer> customerList = customerVehiclesService.getCustomerVehicles();
		assertEquals(customerList.get(0).getId(), customer.getId());
		assertEquals(customerList.get(0).getAddress(), customer.getAddress());
		assertEquals(customerList.get(0).getName(), customer.getName());
		assertTrue(customerList.get(0).getVehicles().isEmpty());
	}
	@Test
	public void testGetCustomerVehicles_GetCustomerFail_Then_Retrun_EmptyList() {
		
		when(customerManagerAdapter.getAllCustomers()).thenReturn(null);
		List<Customer> customerList = customerVehiclesService.getCustomerVehicles();
		assertTrue(customerList.isEmpty());
	}
}
