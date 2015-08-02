package com.technoficent.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.technoficent.rest.dao.EmployeeDAO;
import com.technoficent.rest.entities.Employee;
import com.technoficent.rest.exceptions.BusinessException;
import com.technoficent.rest.to.Status;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeSEI {
	
	@Autowired
	private EmployeeDAO empDAO; 
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BusinessException.class)
	@Override
	public Employee getEmpoyeeDetails(String id) throws BusinessException {
		return empDAO.getEmpoyeeDetails(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BusinessException.class)
	@Override
	public Status updateEmployee(Employee employee) throws BusinessException {
		return empDAO.updateEmployee(employee);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BusinessException.class)
	@Override
	public Status deleteEmployeeByEmpID(String empID) throws BusinessException {
		return empDAO.deleteEmployeeByEmpID(empID);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BusinessException.class)
	@Override
	public Status addEmployee(Employee employee) throws BusinessException {
		return empDAO.addEmployee(employee);
	}
}
