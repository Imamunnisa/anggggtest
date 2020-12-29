package com.example.jenkinsgit.jenkinsgit.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.jenkinsgit.jenkinsgit.exception.ResourceNotFoundException;
import com.example.jenkinsgit.jenkinsgit.model.Project;
import com.example.jenkinsgit.jenkinsgit.repository.projectRepository;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class projectcontroller {
    @Autowired
    private projectRepository projectrepository;
/*
    @GetMapping("/projects")
    public List<Project> getProject() {
        return projectrepository.findAll();
    }
*/
    @GetMapping("/projects/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "projectId") Integer projectId) throws ResourceNotFoundException {
        Project project = projectrepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
        return ResponseEntity.ok().body(project);

    }

    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectrepository.save(project);
    }
    
    /*@PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateEmployee(@PathVariable(value = "id") Integer projectId,
            @Valid @RequestBody Project projectDetails) throws ResourceNotFoundException{
        Project project = projectrepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + projectId));
        project.setId(projectDetails.getId());
        project.setProjectName(projectDetails.getProjectName());
        project.setProjectDescription(projectDetails.getProjectDescription());
        final Project updatedEmployee = projectrepository.save(project);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/projects/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer projectId) throws ResourceNotFoundException{
        Project project = projectrepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + projectId));
       projectrepository.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/

    
    @PutMapping("/projects/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "projectId") Integer projectId,
         @Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
        Project project = projectrepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        project.setProjectId(projectDetails.getProjectId());
        project.setProjectName(projectDetails.getProjectName());
        project.setProjectDescription(projectDetails.getProjectDescription());
       // project.setStartDate(projectDetails.getStartDate());
       // project.setEndDate(projectDetails.getEndDate());
        //project.setTasks(projectDetails.getTasks());
        final Project updatedProject = projectrepository.save(project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/projects/{projectId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "projectId") Integer projectId)
         throws ResourceNotFoundException {
        Project project = projectrepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        projectrepository.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    
}