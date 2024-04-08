package com.example.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepository;
    
	/* http://localhost:8080/employees/1 */
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}
	/* http://localhost:8080/employees */
	@GetMapping("/employees")
	public List<Employee> getAllUsers() {
		return employeeRepository.findAll();
	}
 
}