package se.alten.vehiclesimulator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Vehicle {

	@Id
	@Column(name="vehicle_Id")
	String vehicleId ;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	
}
