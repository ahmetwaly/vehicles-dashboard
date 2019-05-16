package se.alten.customermanger.applicationservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.alten.customermanger.model.entities.Customer;
import se.alten.customermanger.model.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	CustomerRepository customerRepositry ;
	
	/* (non-Javadoc)
	 * @see se.alten.customermanger.applicationservice.CustomerServiceIfc#findCustomerById(int)
	 */
	@Override
	public Customer findCustomerById(int customerId) {
		Optional<Customer> customer = customerRepositry.findById(customerId) ;
		return customer.isPresent()?customer.get():null;
	}

	/* (non-Javadoc)
	 * @see se.alten.customermanger.applicationservice.CustomerServiceIfc#findAllCustomer()
	 */
	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customers = customerRepositry.findAll() ;
		return customers;
	}

}
