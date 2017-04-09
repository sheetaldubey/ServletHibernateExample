package com.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.model.Employee;
import com.example.model.Project;

public abstract class AbstractHelper {
	protected static SessionFactory sessionFactory = getSessionFactory();

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Project.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
