package se.alten.customermanagre;

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

import se.alten.customermanager.CustomerManager;
import se.alten.customermanager.applicationservice.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerManager.class)
@AutoConfigureMockMvc
@ActiveProfiles("development")
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@SpyBean
	CustomerService customerService;

	@Test
	public void testFindAllCustomers_Success() throws Exception {
		mockMvc.perform(get("/customers")).andExpect(status().isOk()).andExpect(content().json(
				"[{\"id\":1,\"address\":\"Cementvägen 8, 111 11 Södertälje\",\"name\":\"Kalles Grustransporter AB\"},{\"id\":2,\"address\":\"Cementvägen 8, 111 11 Södertälje\",\"name\":\"Johans Bulk AB\"},{\"id\":3,\"address\":\"Budgetvägen 1, 333 33 Uppsala\",\"name\":\"Haralds Värdetransporter AB\"}]"));
	}

	@Test
	public void testFindCustomerById_Success() throws Exception {
		mockMvc.perform(get("/customers/1")).andExpect(status().isOk()).andExpect(content().json(
				"{\"id\":1,\"address\":\"Cementvägen 8, 111 11 Södertälje\",\"name\":\"Kalles Grustransporter AB\"}"));
	}

	@Test
	public void testFindCustomer_Invalid_Id_then_404_Error() throws Exception {
		mockMvc.perform(get("/customers/10")).andExpect(status().isNotFound());
	}

	@Test
	public void testFindCustomers_When_General_Error_Then_500_Error_Code() throws Exception {
		doThrow(new RuntimeException()).when(customerService).findAllCustomers();
		mockMvc.perform(get("/customers")).andExpect(status().isInternalServerError());
	}

}