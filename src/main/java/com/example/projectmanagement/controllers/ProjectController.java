package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;

    public ProjectController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        model.addAttribute("project", aProject);

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";

    }

    @PostMapping("/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
        projectRepository.save(project);

        Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);

        for (Employee emp : chosenEmployees){
            List<Project> projects = new ArrayList<>();
            projects.add(project);
            emp.setProjects(projects);
            employeeRepository.save(emp);
        }
        return "redirect:/projects/new";
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute(projectList);

        return "projects/display-projects";
    }

}
