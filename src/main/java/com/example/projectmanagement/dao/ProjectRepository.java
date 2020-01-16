package com.example.projectmanagement.dao;

import com.example.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    public List<Project> findAll();

}
