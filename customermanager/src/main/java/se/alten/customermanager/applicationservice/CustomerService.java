package se.alten.customermanager.applicationservice;

import java.util.List;

import org.springframework.stereotype.Service;

import se.alten.customermanager.model.entities.Customer;
@Service
public interface CustomerService {

	Customer findCustomerById(int customerId);

	List<Customer> findAllCustomers();

}