package se.alten.customervehiclemanager.infrastructure.vehiclemanageradapter;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface VehicleManagerAdapter {

	List<VehicleDto> getAllVehicles() ;

}