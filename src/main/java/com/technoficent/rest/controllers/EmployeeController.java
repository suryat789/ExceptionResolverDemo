package com.technoficent.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technoficent.rest.entities.Employee;
import com.technoficent.rest.exceptions.BusinessException;
import com.technoficent.rest.services.EmployeeSEI;
import com.technoficent.rest.to.Status;


@RestController
@RequestMapping("/data")
public class EmployeeController implements EmployeeSEI {
	
	@Autowired
	private EmployeeSEI empService;
	
	@Override
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	/*@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Does Not Exist.")
	@ExceptionHandler(BusinessException.class)*/
	public Employee getEmpoyeeDetails(@PathVariable(value = "id") String id) throws BusinessException {
		System.out.println("getEmpoyeeDetails EmpID: " + id);
		return empService.getEmpoyeeDetails(id);
	}
	
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Employee employee) throws BusinessException {
		System.out.println(employee);
		return empService.addEmployee(employee);
	}

	@Override
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status updateEmployee(@RequestBody Employee employee) throws BusinessException {
		System.out.println(employee);
		return empService.updateEmployee(employee);
	}

	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployeeByEmpID(@PathVariable("id") String empID) throws BusinessException {
		return empService.deleteEmployeeByEmpID(empID);
	}
}