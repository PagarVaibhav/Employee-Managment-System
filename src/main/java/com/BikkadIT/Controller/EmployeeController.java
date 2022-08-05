package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Service.ServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceImpl serviceImpl;
	
	// Add Employee
	
	@PostMapping(value="/add" ,consumes = "application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		
		Employee addEmployee = serviceImpl.addEmployee(employee);
		
		return new ResponseEntity<Employee>(addEmployee , HttpStatus.CREATED);
	}
	
	// Add Multiple Employee
	
	@GetMapping(value="/addMulti" ,consumes = "application/json")
	public ResponseEntity<String> addMultiEmployee(@RequestBody List<Employee> employee){
		
		serviceImpl.addMultiEmployee(employee);
		
		String msg="Saved Multiple Employees";
		
		return new ResponseEntity<>(msg , HttpStatus.OK);
	}
	
	// Get By Id
	
	@GetMapping(value="/getid/{id}" , consumes = "application/json")
	public ResponseEntity<Employee> getById(@PathVariable Integer id){
		
		Employee byId = serviceImpl.getById(id);
		return new ResponseEntity<Employee>(byId , HttpStatus.OK);
	}
	// Get All
	
	@GetMapping(value="/getAll" , produces = "application/json" ,consumes = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> allEmployee = serviceImpl.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee ,HttpStatus.OK) ;
	}
	// Age Less Than Equal
	
	@GetMapping(value="/lesscondition/{age}" , consumes = "application/json")
	public ResponseEntity<List<Employee>> lessThanEqualTo(@PathVariable Integer age){
		
		List<Employee> lessThanEqual = serviceImpl.lessThanEqual(age);
		return new ResponseEntity<List<Employee>>(lessThanEqual,HttpStatus.OK);
	}
	// Update Single
	
     @PostMapping(value="/update" ,consumes = "application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		
		Employee updateEmployee = serviceImpl.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
		
	}
     // Update Multiple

 	@GetMapping(value="/updateMulti",consumes = "application/json")
 	public ResponseEntity<String> updateMultiEmp(@RequestBody List<Employee> employee){
 		
 		serviceImpl.updateMultiple(employee);
 		
 		String msg="Updated Multiple Employee Data";
 		
 		return new ResponseEntity<>(msg,HttpStatus.OK);
 	}
     // Login Check
     
     @GetMapping(value="/login/{empEmail}/{empName}" , produces = "application/json")
     public ResponseEntity<Employee> loginCheck(@PathVariable String empEmail ,@PathVariable String empName) {
    	 
    	 System.out.println(empEmail+ " "+empName);
		
    	 Employee loginCheck = serviceImpl.loginCheck(empEmail, empName);
    	 
    	 return new ResponseEntity<Employee>(loginCheck,HttpStatus.OK);
 		
     }
     // Delete By Id
     
     @GetMapping(value="/delete/{empId}",consumes = "application/json")
     public ResponseEntity<String> deleteByEmpId(@PathVariable Integer empId){
    	 
    	 serviceImpl.deleteEmpById(empId);
    	 
    	 String msg="Delete Perticular Id Successfully";
		 return new ResponseEntity<String>(msg , HttpStatus.OK);
    	 
     } 
     // Delete All
     
     @GetMapping(value="/deleteAll")
 	public ResponseEntity<String> deleteAllData(){
 		
    	serviceImpl.deleteAllEmployee();
    	
    	String msg="All Data Deleted Successfully";
    	
		return new ResponseEntity<>(msg,HttpStatus.OK);
 	}
}
