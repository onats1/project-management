package com.example.projectmanagement.controllers;


import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee nEmployee = new Employee();
        model.addAttribute("employee",nEmployee);

        return "employee/new-employee";
    }

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employeeList = repository.findAll();
        model.addAttribute(employeeList);

        return "employee/display-employees";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee, Model model){
        repository.save(employee);
        return "redirect:/employees/new";
    }
}
