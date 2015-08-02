package com.technoficent.rest.dao;

import java.util.List;

import javax.persistence.Query;

import com.technoficent.rest.entities.Employee;
import com.technoficent.rest.exceptions.BusinessException;
import com.technoficent.rest.to.Status;
import com.technoficent.rest.to.StatusConstants;

@SuppressWarnings(value = "unchecked")
public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO {

	@Override
	public Employee getEmpoyeeDetails(String id) throws BusinessException {
		Query query = getEntityManager().createQuery(" from Employee emp WHERE emp.employeeID = :employeeID");
		query.setParameter("employeeID", id);

		List<Employee> employees = query.getResultList();
		if (employees != null && !employees.isEmpty()) {
			return employees.get(0);
		}
		else {
			throw new BusinessException("EmployeeNotFoundException", BusinessException.ExceptionLevel.SEVERE);
		}
	}

	public Status updateEmployee(Employee employee) throws BusinessException {
		Status status = null;
		try {
			getEntityManager().merge(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception ex) {
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			throw new BusinessException("EmployeeNotFoundException", ex, BusinessException.ExceptionLevel.SEVERE);
		}
		return status;
	}

	public Status deleteEmployeeByEmpID(String empID) throws BusinessException {
		Status status = null;
		try {
			Employee employee = getEmpoyeeDetails(empID);
			delete(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception ex) {
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			throw new BusinessException("EmployeeNotFoundException", ex, BusinessException.ExceptionLevel.SEVERE);
		}
		return status;
	}

	@Override
	public Status addEmployee(Employee employee) throws BusinessException {
		Status status = null;
		try {
			persist(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception ex) {
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			throw new BusinessException("EmployeeNotFoundException", ex, BusinessException.ExceptionLevel.SEVERE);
		}
		return status;
	}
}
