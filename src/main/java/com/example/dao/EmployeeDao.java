package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Employee;
import com.example.utils.AbstractHelper;

public class EmployeeDao extends AbstractHelper {

	public Employee upsert(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer employeeId = (Integer) session.save(employee);
		transaction.commit();
		session.flush();
		session.close();
		Employee dbEmployee = findOne(employeeId);
		return dbEmployee;
	}

	public Employee delete(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(employee);
		transaction.commit();
		session.flush();
		session.close();
		return employee;
	}

	public Employee findOne(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee dbEmployee = (Employee) session.get(Employee.class, employeeId);
		return dbEmployee;
	}

	public List<Employee> findAll() {
		Session session = sessionFactory.openSession();
		List<Employee> employees = session.createCriteria(Employee.class).list();
		session.close();
		return employees;
	}

}
