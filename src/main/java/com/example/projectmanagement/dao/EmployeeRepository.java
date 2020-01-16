package com.example.projectmanagement.dao;

import com.example.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findAll();
}
