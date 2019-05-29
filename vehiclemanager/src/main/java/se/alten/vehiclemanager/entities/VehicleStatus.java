package se.alten.vehiclemanager.entities;

public enum VehicleStatus {
	CONNECTED(1), DISCONNECTED(0);
	private int vehicleStatus;

	private VehicleStatus(int vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public int getVehicleStatus() {
		return this.vehicleStatus;
	}

	public void setVehicleStatus(int vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public static VehicleStatus parse(int statusValue) {
		VehicleStatus status = null;
		for (VehicleStatus item : VehicleStatus.values()) {
			if (item.getVehicleStatus() == statusValue) {
				status = item;
				break;
			}
		}
		return status;
	}
}
