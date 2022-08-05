package com.BikkadIT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Repository.EmployeeRepo;

@Service
public class ServiceImpl {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		
		Employee emp = employeeRepo.save(employee);
		
		return emp;
	}
	
	public void addMultiEmployee(List<Employee> employee){
		
		List<Employee> saveAll = employeeRepo.saveAll(employee);
		
		
	}
	
    public Employee getById(Integer id) {
		
		Employee findByEmpId = employeeRepo.findByEmpId(id);
		
		return findByEmpId;
	}
    
    public List<Employee> getAllEmployee(){
    	
    	List<Employee> findAll = employeeRepo.findAll();
		return findAll;
    }
    
    public List<Employee> lessThanEqual(Integer age) {
    	
    	List<Employee> findByEmpAgeLessThanEqual = employeeRepo.findByEmpAgeLessThanEqual(age);
	
    	return findByEmpAgeLessThanEqual;
  
    }
    
    public Employee updateEmployee(Employee employee) {
    	
    	Employee save = employeeRepo.save(employee);
		return save;
    	
    }
    
    public void updateMultiple(List<Employee> employee) {
		employeeRepo.saveAll(employee);
		
	}
    
    public Employee loginCheck(String empEmail , String empName) {
    	
    	Employee idAndEmpname = employeeRepo.findByEmpEmailAndEmpName(empEmail, empName);
    	
    	return idAndEmpname;
    	
    }
    
    public void deleteEmpById(Integer empId) {
    	
    	employeeRepo.deleteById(empId);
    	
    }
    
    public void deleteAllEmployee() {
		employeeRepo.deleteAll();
	}
}
