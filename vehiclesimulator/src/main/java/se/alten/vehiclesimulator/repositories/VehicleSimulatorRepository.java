package se.alten.vehiclesimulator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se.alten.vehiclesimulator.model.Vehicle;

@Repository
public interface VehicleSimulatorRepository extends JpaRepository<Vehicle,String> {
	
	
}

