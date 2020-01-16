package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ProjectRepository repository;
    private EmployeeRepository employeeRepository;

    public HomeController(ProjectRepository repository, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = repository.findAll();
        model.addAttribute("projects", projects);

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees",employees);

        return "main/home";
    }
}
