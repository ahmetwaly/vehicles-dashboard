package se.alten.customervehiclemanager.applicationservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.alten.customervehiclemanager.infrastructure.customermanageradapter.CustomerDto;
import se.alten.customervehiclemanager.infrastructure.customermanageradapter.CustomerManagerAdapter;
import se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter.VehicleDto;
import se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter.VehicleManagerAdapter;

@Service
public class CustomerVehiclesService {

	@Autowired
	VehicleManagerAdapter vehicleManagerAdapter;

	@Autowired
	CustomerManagerAdapter customerManagerAdapter;

	public List<Customer> getCustomerVehicles() {
		List<CustomerDto> customerDtos = customerManagerAdapter.getAllCustomers();
		if(null!=customerDtos && !customerDtos.isEmpty()) {
			List<Customer> customers = CustomerVehicleMapper.INSTANCE.toCustomers(customerDtos);
			List<VehicleDto> vehicleDtos = vehicleManagerAdapter.getAllVehicles();
			List<Vehicle> vehicles = CustomerVehicleMapper.INSTANCE.toVehicles(vehicleDtos);
			if (null != vehicles && !vehicles.isEmpty()) {
				customers.forEach(customer -> {
					customer.setVehicles(vehicles.stream().filter(vehicle -> vehicle.getCustomerId() == customer.getId())
							.collect(Collectors.toList()));
				});
			}
			return customers;
		}
		return new ArrayList<>();
	}
}