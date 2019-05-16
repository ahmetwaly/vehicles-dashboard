package se.alten.customermanger.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se.alten.customermanger.model.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}

