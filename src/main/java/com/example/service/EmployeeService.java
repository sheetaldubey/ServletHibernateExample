package com.example.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.dao.EmployeeDao;
import com.example.dao.ProjectDao;
import com.example.model.Employee;
import com.example.model.Project;

public class EmployeeService {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	private static final ProjectService PROJECT_SERVICE = new ProjectService();

	private static final EmployeeDao EMPLOYEE_DAO = new EmployeeDao();

	public Employee getEmployee(Integer employeeId) {
		return EMPLOYEE_DAO.findOne(employeeId);

	}

	public Employee createEmployee(String employeeName, String employeeSalary, String employeeDOB,
			String employeeManagerId, String employeeProjectId) {
		Employee employee = new Employee();
		employee.setName(employeeName);
		try {
			employee.setSalary(Integer.parseInt(employeeSalary));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			employee.setDateOfBirth(DATE_FORMAT.parse(employeeDOB));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			employee.setProject(PROJECT_SERVICE.getProject(Integer.parseInt(employeeProjectId)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			employee.setManager(getEmployee(Integer.parseInt(employeeManagerId)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Employee dbEmployee = EMPLOYEE_DAO.upsert(employee);

		return dbEmployee;
	}

}
