package com.example.projectmanagement.dao;

import com.example.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
