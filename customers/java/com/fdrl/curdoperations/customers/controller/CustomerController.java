package com.fdrl.curdoperations.customers.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdrl.curdoperations.customers.model.Customer;
import com.fdrl.curdoperations.customers.service.CustomerService;

@RestController
@RequestMapping("/customers")                         // Used at the class level to map web requests
public class CustomerController {                     // Class defined

    @Autowired                                         // Used for automatic injection dependency (tells spring to inject CustomerService into this controller)
    private CustomerService customerService;           // Reference to customerService which provides customer related operations
    @GetMapping("/allCustomers")                           // Method to get all customers
    public List<Customer> getAllCustomers() {   
      return customerService.getAllCustomers();             // Calls the getAllCustomers and returns the result
    }
    @GetMapping("/customerById/{id}")                         // Method to get CustomerById
    public String getCustomerById(@PathVariable int id) {     // Takes integer id as path variable and returns a string
    	Optional<Customer> customerOptional = customerService.getCustomerById(id);   // Method calls get CustomerById
    	if (customerOptional.isPresent()) {                      // Check if a customer with the given id is present
    		Customer customer = customerOptional.get();
    		ObjectMapper objectMapper = new ObjectMapper();        // Instance used for java objects to JSON
    		try {
    			return objectMapper.writeValueAsString(customer);     // Converts customer object to a JSON string and it returns 
    			} catch (JsonProcessingException e) {
    				e.printStackTrace();
    				return "Error converting customer to JSON";       // Catches if any error may occur during JSON conversion, print stack trace and returns a error message
    				}
    		} else {
    			return "No Data Available";                 // If the customer is not present, returns a message "No Data Available"
    			}
    }
    @PostMapping("/updatedFromFile")                                          // Defines a POST end point
    public ResponseEntity<String> processFileAndSave() throws Exception {    // Define method to process and save the files
    	customerService.saveCustomersFromFileInResources();
    	return ResponseEntity.ok("Data saved successfully from file");      // Returns a message "Data saved successfully from file"
    	}
    }
  

























































//@PostMapping("/updatedFromFile")                                             // Defines a POST end point
//public ResponseEntity<String> processFileAndSave() throws Exception {    // Define method to process and save the file
//	try {
//		customerService.saveCustomersFromFileInResources();
//		return ResponseEntity.ok("Data saved successfully from file");
//		} catch (IOException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file: " + e.getMessage()); // Returns an HTTP status 500 INTERNAL SERVER ERROR response
//			}
//	}
//}























//@PostMapping("/updateFromFile")
//public ResponseEntity<String> processFileAndSave() {
//  try {
//      customerService.saveCustomersFromFileInResources();
//      return ResponseEntity.ok("Data saved successfully from file");
//  } catch (IOException e) {
//      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                           .body("Failed to process file: " + e.getMessage());
//  }
//}










//
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fdrl.curdoperations.customers.model.Customer;
//import com.fdrl.curdoperations.customers.service.CustomerService;
//
//@RestController
//@RequestMapping("/customers")                                 // Used at the class level to map web requests
//public class CustomerController {                             // Class defined
//	
//    @Autowired                                                // Used for automatic injection dependency (tells spring to inject CustomerService into this controller)
//    private CustomerService customerService;                  // Reference to customerService which provides customer related operations
//    
//    @GetMapping("/allcustomers")                              // Method to get all customers
//    public List<Customer> getAllCustomers() {   
//        return customerService.getAllCustomers();             // Calls the getAllCustomers and returns the result
//        }
//    @GetMapping("/customerById/{id}")                         // Method to get CustomerById
//    public String getCustomerById(@PathVariable int id) {     // Takes integer id as path variable and returns a string
//        Optional<Customer> customerOptional = customerService.getCustomerById(id);   // Method calls get CustomerById
//        if (customerOptional.isPresent()) {                      // Check if a customer with the given id is present
//        	Customer customer = customerOptional.get();
//        	ObjectMapper objectMapper = new ObjectMapper();      // Instance used for java objects to JSON
//        	try {
//        		return objectMapper.writeValueAsString(customer);     // Converts customer object to a JSON string and it returns 
//        		} catch (JsonProcessingException e) {
//        			e.printStackTrace();
//        			return "Error converting customer to JSON";       // Catches if any error may occur during JSON conversion, print stack trace and returns a error message
//        			}
//        	} else {
//        		return "No Data Available";                 // If the customer is not present, returns a message "No Data Available"
//        		}
//        }
//    @PostMapping("/updatedfile")                            // Defines a POST end point
//    public ResponseEntity<String> processFileAndSave() {    // Define method to process and save the file
//    	try {
//    		customerService.saveCustomersFromFileInResources();
//    		return ResponseEntity.ok("Data saved successfully from file");
//    		} catch (IOException e) {
//    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file: " + e.getMessage()); // Returns an HTTP status 500 INTERNAL SERVER ERROR response
//    			}
//    	}
//    }
 


//@GetMapping("/byId/{id}")
//public ResponseEntity<?> getCustomerById(@PathVariable int id) {
//  Optional<Customer> customerOptional = customerService.getCustomerById(id);
//  if (customerOptional.isPresent()) {
//      Customer customer = customerOptional.get();
//      return ResponseEntity.ok(customer);
//  } else {
//      return ResponseEntity.notFound().build();
//  }
//}









































































//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.security.PublicKey;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.hibernate.annotations.Array;
//import org.json.JSONArray;
//import org.json.JSONObject;
////import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fdrl.curdoperations.customers.model.CustomerEntity;
//import com.fdrl.curdoperations.customers.repository.CustomerRepo;

//@RequestMapping("/customers")
//@RestController
//public class CustomerController {

	

//  @Autowired private CustomerRepo customerRepo;

//	@PostMapping("/")
//	public ResponseEntity<CustomerEntity> create(@RequestBody CustomerEntity customers) {
//		return ResponseEntity.ok(customerRepo.save(customers));
//	}

	// @DeleteMapping("/delete")
	// public ResponseEntity<CustomerEntity> delete(@RequestBody CustomerEntity
	// customers) {
	// return ResponseEntity.ok(customerRepo.save(customers));
	// }

	/*
	 * @GetMapping("/findAll") public ResponseEntity<List<CustomerEntity>> findAll()
	 * {
	 * 
	 * return ResponseEntity.ok(customerRepo.findAll()); }
	 */

//	@GetMapping("getCustomer")
//	public ResponseEntity<?> getCustomerById(@RequestParam int id) throws IOException {
//        ObjectMapper obj = new ObjectMapper();
//		File file = new File("E:\\hp\\Downloads\\Userslist.txt");
//
//        List<Map> customers= obj.readValue(file, new TypeReference<List<Map>>() {
//		});
//
//		for (Map map : customers) {
//			
//			if ((int) map.get("id") == id) {
//				return ResponseEntity.ok("customer present for this ID");
//			} else {}
//
//		}
//		return ResponseEntity.ok("No customer present for this ID");
//
//	}
//
//}


	

