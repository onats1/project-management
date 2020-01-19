package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.dto.ChartData;
import com.example.projectmanagement.dto.EmployeeProject;
import com.example.projectmanagement.entities.Project;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = repository.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = repository.getProjectStatus();

        // Convert projectData object into a json structure

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCnt", jsonString);


        List<EmployeeProject> employeesProjectCnt = employeeRepository.employeeProjects();
        model.addAttribute("employeesProjectCnt", employeesProjectCnt);

        return "main/home";
    }
}
