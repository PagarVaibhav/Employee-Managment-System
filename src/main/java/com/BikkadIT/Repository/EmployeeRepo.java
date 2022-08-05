package com.BikkadIT.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.Model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Serializable> {

	public Employee findByEmpId(Integer id);
	
	public List<Employee> findByEmpAgeLessThanEqual(Integer age);
	
	public Employee findByEmpEmailAndEmpName(String empEmail , String empName);

	
}
