package se.alten.customervehiclemanager.applicationservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.alten.customervehiclemanager.dto.Customer;
import se.alten.customervehiclemanager.dto.Vehicle;
import se.alten.customervehiclemanager.infrastructure.customermanageradapter.CustomerManagerAdapter;
import se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter.VehicleManagerAdapter;

@Service
public class CustomerVehiclesService {

	@Autowired
	VehicleManagerAdapter vehicleManagerAdapter;

	@Autowired
	CustomerManagerAdapter customerManagerAdapter;

	public List<Customer> getCustomerVehicles() {
		List<Customer> customerDtos = customerManagerAdapter.getAllCustomers();
		if(null!=customerDtos && !customerDtos.isEmpty()) {
			List<Vehicle> vehicleDtos = vehicleManagerAdapter.getAllVehicles();
			if (null != vehicleDtos && !vehicleDtos.isEmpty()) {
				customerDtos.forEach(customer -> {
					customer.setVehicles(vehicleDtos.stream().filter(vehicle -> vehicle.getCustomerId() == customer.getId())
							.collect(Collectors.toList()));
				});
			}
			return customerDtos;
		}
		return new ArrayList<>();
	}
}