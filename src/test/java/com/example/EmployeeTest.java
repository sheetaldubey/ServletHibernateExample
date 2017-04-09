package com.example;

import java.util.Date;
import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.dao.ProjectDao;
import com.example.model.Employee;
import com.example.model.Project;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDao();
		ProjectDao projectDao = new ProjectDao();
		List<Employee> employees = employeeDao.findAll();
		System.out.println(employees);

		Employee employee = new Employee();
		employee.setName("Shubham Patel");
		employee.setDateOfBirth(new Date(1993, 8, 16));
		employee.setSalary(2000);
		Project project = new Project();
		project.setProjectName("TestProject4");
		Project dbProject = projectDao.upsert(project);
		employee.setProject(dbProject);
		System.out.println(employeeDao.upsert(employee));
	}
}
