package se.alten.customermanger.applicationservice;

import java.util.List;

import org.springframework.stereotype.Service;

import se.alten.customermanger.model.entities.Customer;
@Service
public interface CustomerService {

	Customer findCustomerById(int customerId);

	List<Customer> findAllCustomer();

}