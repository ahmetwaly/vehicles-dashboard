package se.alten.customervehiclemanager.restcontroller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import se.alten.customervehiclemanager.applicationservice.CustomerVehiclesService;
import se.alten.customervehiclemanager.dto.Customer;

/**
 * rest controller provide the rest operations for the customers
 */
@RestController
@RequestMapping(path = "/")
@ControllerAdvice
public class CustomerVehiclesController {

	private static final Logger logger = LogManager.getLogger(CustomerVehiclesController.class);

	@Autowired
	CustomerVehiclesService customerVehiclesService;

	public static final String customErrorLogMessage = " request:%s thrown error:%s";


	/**
	 * return all customer and vehicle information
	 * 
	 * @return {@link List}
	 */
	@ApiOperation(value = "return all customers and vehicle information, empty list if non", response = List.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "sucess response "),
	        @ApiResponse(code = 500, message = "somthing went wrong , please try again later"),
	})
	
	@RequestMapping(value = "/customervehicles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> findAllCustomers() {
		List<Customer> customers = customerVehiclesService.getCustomerVehicles();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK) ;
	}
	


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handelException(HttpServletRequest req,
			Exception genericException) {
		logger.error(
				String.format(customErrorLogMessage, req.getRequestURI(),genericException.getStackTrace()));
		return new ResponseEntity<>(genericException.getMessage(), HttpStatus.valueOf(500));
	}
}
