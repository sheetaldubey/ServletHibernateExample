package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Employee;
import com.example.model.Project;
import com.example.utils.AbstractHelper;

public class ProjectDao extends AbstractHelper {

	public Project upsert(Project project) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer projectId = (Integer) session.save(project);
		transaction.commit();
		session.flush();
		session.close();
		Project dbProject = findOne(projectId);
		return dbProject;
	}

	public Project delete(Project project) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(project);
		transaction.commit();
		session.flush();
		session.close();
		return project;
		
	}

	public Project findOne(Integer projectId) {
		Session session = sessionFactory.openSession();
		Project dbProject = (Project) session.get(Project.class, projectId);
		return dbProject;
	}

	public List<Project> findAll() {
		Session session = sessionFactory.openSession();
		List<Project> projects = session.createCriteria(Project.class).list();
		session.close();
		return projects;
	}

}
