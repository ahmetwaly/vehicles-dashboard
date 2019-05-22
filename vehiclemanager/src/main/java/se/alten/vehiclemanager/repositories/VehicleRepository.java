package se.alten.vehiclemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se.alten.vehiclemanager.entities.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	
	
}

