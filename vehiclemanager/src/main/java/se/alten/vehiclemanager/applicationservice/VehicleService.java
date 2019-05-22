package se.alten.vehiclemanager.applicationservice;

import java.util.List;


public interface VehicleService {

	VehicleDto findVehicleByVehicleId(String regNumber);

	List<VehicleDto> findAllVehicles();
	
	VehicleDto updateVehicleStatus(String vehicleId, String status);

}