package com.example.jenkinsgit.jenkinsgit.model;

import javax.persistence.CascadeType;
//import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

//import javax.persistence.CascadeType;
@EnableAutoConfiguration 
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "projectId",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "projectId",nullable = false)
    //@JsonProperty("projectId")
    

    @Column(name = "projectName",nullable = false)
    private String projectName;

    @Column(name = "projectDescription",nullable = false)
    private String projectDescription;

   // @DateTimeFormat(pattern = "dd-MM-yyyy")
/*
    @Column(name = "startDate",nullable = false)
    private Date startDate;


    @Column(name = "endDate",nullable = false)
    private Date endDate;

 */   
  
 
 
 
 
 /*@OneToMany(targetEntity = Task.class,cascade = CascadeType.ALL)
    @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "taskId") 
   // @Fetch(FetchMode.JOIN)
    //@JoinColumn(name = "project_id", referencedColumnName = "id")
    List < Task > tasks = new ArrayList < > ();

*/
    public Project() {

    } 
    public Project(Integer projectId,String projectName,String projectDescription){
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
       // this.startDate = startDate;
       // this.endDate = endDate;
    }
    public Integer getProjectId() {
        return projectId;
    }
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getProjectDescription() {
        return projectDescription;
    }
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    
 /*  
    public Date getStartDate(){
        return startDate;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

*/

/*
    public List < Task > getTasks() {
        return tasks;
    }

    public void setTasks(List < Task > tasks) {
        this.tasks = tasks;
    }

    
    @Override
    public String toString(){
        return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + projectDescription +",]";
        //, startDate=" + startDate + ", endDate=" + endDate +
        
        
    }

    //, startDate=" + startDate + ", endDate=" + endDate +"]";
    //,Date startDate, Date endDate
*/
    

}