package com.example.service;

import com.example.dao.ProjectDao;
import com.example.model.Project;

public class ProjectService {
	private static final ProjectDao PROJECT_DAO = new ProjectDao();
	
	public Project getProject(Integer projectId){
		return PROJECT_DAO.findOne(projectId);
		
	}

}
