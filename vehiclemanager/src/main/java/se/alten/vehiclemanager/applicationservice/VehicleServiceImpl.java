package se.alten.vehiclemanager.applicationservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.alten.vehiclemanager.entities.Vehicle;
import se.alten.vehiclemanager.entities.VehicleStatus;
import se.alten.vehiclemanager.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService  {

	@Autowired 
	VehicleRepository vehilceRepositry ;
	

	@Override
	public VehicleDto findVehicleByVehicleId(String vehicleId) {
		Optional<Vehicle> vehicle = vehilceRepositry.findById(vehicleId) ;
		return vehicle.isPresent()? VehicleMapper.INSTANCE.toVehicleDto(vehicle.get()):null;
	}

	@Override
	public List<VehicleDto> findAllVehicles() {
		List<Vehicle> vehicles = vehilceRepositry.findAll() ;
		return VehicleMapper.INSTANCE.toVehicleDtos(vehicles);
	}

	@Override
	public VehicleDto updateVehicleStatus(String vehicleId , String status) {
		Optional<Vehicle> vehicleOptional = vehilceRepositry.findById(vehicleId) ;
		if(vehicleOptional.isPresent()) {
			Vehicle vehicle = vehicleOptional.get();
			vehicle.setStatus(VehicleStatus.valueOf(status));
			vehilceRepositry.save(vehicle);
			return VehicleMapper.INSTANCE.toVehicleDto(vehicle);
		}
		return null;
	}
	
}
