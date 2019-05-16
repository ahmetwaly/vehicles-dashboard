package se.alten.customermanger.restcontroller;

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
import se.alten.customermanger.applicationservice.CustomerService;
import se.alten.customermanger.model.entities.Customer;

/**
 * rest controller provide the rest operations for the customers
 */
@RestController
@RequestMapping(path = "/")
@ControllerAdvice
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	public static final String customErrorLogMessage = " request:%s thrown error:%s";


	/**
	 * return customer by customerId
	 * 
	 * @return Customer
	 */
	@ApiOperation(value = "return all customers , empty list if non", response = List.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "sucess response "),
	        @ApiResponse(code = 500, message = "somthing went wrong , please try again later"),
	})
	
	@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> findAllCustomers() {
		List<Customer> customers = customerService.findAllCustomer();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK) ;
	}
	

	/**
	 * return customer by customerId
	 * 
	 * @return Customer
	 */
	@ApiOperation(value = "return the customer by customerId", response = Customer.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "customer found "),
	        @ApiResponse(code = 500, message = "somthing went wrong , please try again later"),
	        @ApiResponse(code = 404, message = "the customer was not found"),
	})
	@RequestMapping(value = "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Customer> findCustomerById(@PathVariable(name = "customerId") Integer customerId) {
		Customer customer = customerService.findCustomerById(customerId);
		return null!=customer ? new ResponseEntity<Customer>(customer, HttpStatus.OK) : new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handelException(HttpServletRequest req,
			Exception genericException) {
		logger.error(
				String.format(customErrorLogMessage, req.getRequestURI(),genericException.getMessage()));
		return new ResponseEntity<>(genericException.getMessage(), HttpStatus.valueOf(500));
	}
}
