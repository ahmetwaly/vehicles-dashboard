package se.alten.vehiclemanager.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import se.alten.vehiclemanager.applicationservice.VehicleDto;
import se.alten.vehiclemanager.applicationservice.VehicleService;
import se.alten.vehiclemanager.entities.Vehicle;
import se.alten.vehiclemanager.entities.VehicleStatus;

/**
 * rest controller provide the rest operations for the vehicle
 */
@RestController
@RequestMapping(path = "/")
@ControllerAdvice
public class VehicleController {

	private static final Logger logger = LogManager.getLogger(VehicleController.class);

	@Autowired
	VehicleService vehicleService;

	public static final String customErrorLogMessage = " request:%s thrown error:%s";


	/**
	 * return all Vehicles
	 * 
	 * @return {@link List}
	 */
	@ApiOperation(value = "return all vehicles , empty list if non", response = List.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "sucess response "),
	        @ApiResponse(code = 500, message = "somthing went wrong , please try again later"),
	})
	
	@RequestMapping(value = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<VehicleDto>> findAllVehicles() {
		List<VehicleDto> vehiclesDto = vehicleService.findAllVehicles();
		return new ResponseEntity<List<VehicleDto>>(vehiclesDto, HttpStatus.OK) ;
	}
	
	/**
	 * return vehicle by vehicleId
	 * 
	 * @return {@link VehicleDto}
	 */
	@ApiOperation(value = "return the vehicle by vehicle id", response = VehicleDto.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "vehicle found "),
	        @ApiResponse(code = 500, message = "somthing went wrong , please try again later"),
	        @ApiResponse(code = 404, message = "the vehicle was not found"),
	})
	@RequestMapping(value = "/vehicles/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<VehicleDto> findVehicleByRegNumber(@PathVariable(name = "vehicleId") String vehicleId) {
		VehicleDto vehicle = vehicleService.findVehicleByVehicleId(vehicleId);
		return null!=vehicle ? new ResponseEntity<VehicleDto>(vehicle, HttpStatus.OK) : new ResponseEntity<VehicleDto>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * update status of vehicle
	 * return updated vehicle 
	 * @return {@link VehicleDto}
	 */
	@ApiOperation(value = "update vehicle connection status by vehicle id", response = VehicleDto.class )
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "vehicle status updated successfully  "),
	        @ApiResponse(code = 500, message = "somthing went wrong , please try again later"),
	        @ApiResponse(code = 404, message = "the vehicle was not found"),
	})

	@PatchMapping(value = "/vehicles/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleDto> updateVehicleStatus(@PathVariable(name = "vehicleId") String vehicleId , @RequestBody VehicleUpdateRequestDto vehicleUpdateRequestDto) {
		VehicleDto vehicle =vehicleService.updateVehicleStatus(vehicleId, vehicleUpdateRequestDto.getStatus());
		return null!=vehicle ? new ResponseEntity<VehicleDto>(vehicle, HttpStatus.OK) : new ResponseEntity<VehicleDto>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handelException(HttpServletRequest req, Exception genericException) {
		logger.error(
				String.format(customErrorLogMessage, req.getRequestURI(),genericException.getStackTrace()));
		return new ResponseEntity<>(genericException.getMessage(), HttpStatus.valueOf(500));
	}
}
