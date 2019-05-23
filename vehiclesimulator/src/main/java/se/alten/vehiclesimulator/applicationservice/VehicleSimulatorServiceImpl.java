package se.alten.vehiclesimulator.applicationservice;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.alten.vehiclesimulator.infrastructure.VehicleManagerAdapter;
import se.alten.vehiclesimulator.model.Vehicle;
import se.alten.vehiclesimulator.repositories.VehicleSimulatorRepository;

@Service
public class VehicleSimulatorServiceImpl implements VehicleSimulatorService {

	@Autowired
	VehicleSimulatorRepository vehicleSimulatorRepository ;
	@Autowired
	VehicleManagerAdapter vehicleManagerAdapter ;

	@Override
	public void updateServiceStatus() {
		List<Vehicle> vehicles = vehicleSimulatorRepository.findAll();
		while(true) {
			vehicles.forEach((vehicle)->{
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(50) + 1;
				String status="CONNECTED" ;
				if (randomInt%2==0) status="DISCONNECTED" ;
				vehicleManagerAdapter.updateVechileStatus(vehicle.getVehicleId(), status);
			});
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
