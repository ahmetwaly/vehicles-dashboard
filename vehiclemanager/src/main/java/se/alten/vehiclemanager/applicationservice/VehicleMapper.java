package se.alten.vehiclemanager.applicationservice;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se.alten.vehiclemanager.entities.Vehicle;


@Mapper
public interface VehicleMapper {
	VehicleMapper INSTANCE = Mappers.getMapper( VehicleMapper.class );
	
	VehicleDto toVehicleDto(Vehicle vehicle) ;
    
	List<VehicleDto> toVehicleDtos(List<Vehicle> vehicle);

}
