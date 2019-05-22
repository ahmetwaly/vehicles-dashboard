package se.alten.vehiclemanager.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vehicle {

	@Id
	@Column(name="VEHICLE_ID")
	private String vehicleId ;
	
	@Column(name="REG_NUMBER")
	private String regNumber ;
	
	
	@Column(name="CUSTOMER_ID")
	private Integer customerId ;
	
	@Column(name="STATUS")
	private int status  ;
	
  	@Column(name = "UPDATED_ON", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

	private void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public VehicleStatus getStatus() {
		return VehicleStatus.parse(status);
	}

	public void setStatus(VehicleStatus status) {
		this.status = status.getVehicleStatus();
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}    

	public Vehicle() {
		
	}
	public Vehicle(String vehicleId ,Integer customerId,String regNumber) {
		setCustomerId(customerId);
		setRegNumber(regNumber);
		setStatus(VehicleStatus.DISCONNECTED);
		setVehicleId(vehicleId);
		setUpdatedOn(Calendar.getInstance().getTime());
	}
  	
}
