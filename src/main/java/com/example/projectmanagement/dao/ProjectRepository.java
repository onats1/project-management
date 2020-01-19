package com.example.projectmanagement.dao;

import com.example.projectmanagement.dto.ChartData;
import com.example.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, " +
            "COUNT(*) as value FROM project GROUP BY stage")
    public List<ChartData> getProjectStatus();




}
