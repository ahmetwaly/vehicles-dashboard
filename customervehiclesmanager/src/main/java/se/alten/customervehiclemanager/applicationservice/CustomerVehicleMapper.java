package se.alten.customervehiclemanager.applicationservice;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se.alten.customervehiclemanager.infrastructure.customermanageradapter.CustomerDto;
import se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter.VehicleDto;


@Mapper
public interface CustomerVehicleMapper {

	CustomerVehicleMapper INSTANCE = Mappers.getMapper( CustomerVehicleMapper.class );
	
	List<Vehicle> toVehicles(List<VehicleDto> vehicleDtos);
	
	List<Customer> toCustomers(List<CustomerDto> customerDtos);
	

	

	
}
