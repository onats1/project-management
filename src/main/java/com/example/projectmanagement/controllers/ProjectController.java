package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "new-project";

    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
       projectRepository.save(project);
        return "redirect:/projects/new";
    }

}
