package se.alten.vehiclesimulator.infrastructure;

public class VehicleStatusUpdateRequestDto {
	
	String status ;

	public VehicleStatusUpdateRequestDto(String status) {
		this.status=status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
