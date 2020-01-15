package com.example.projectmanagement.controllers;

import com.example.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @RequestMapping("/new")
    public String displayProjectForm(Model model){

        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "new-project";

    }

   /* @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveProject(){

    }*/

}
