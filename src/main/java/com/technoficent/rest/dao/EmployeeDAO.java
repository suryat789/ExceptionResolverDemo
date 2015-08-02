package com.technoficent.rest.dao;

import com.technoficent.rest.entities.Employee;
import com.technoficent.rest.exceptions.BusinessException;
import com.technoficent.rest.to.Status;


public interface EmployeeDAO {
	
	public Status addEmployee(Employee employee) throws BusinessException;
	
	public Employee getEmpoyeeDetails(String id) throws BusinessException;
	
	public Status updateEmployee(Employee employee) throws BusinessException;
	
	public Status deleteEmployeeByEmpID(String empID) throws BusinessException;
		
}