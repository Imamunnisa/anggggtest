package com.example.jenkinsgit.jenkinsgit.repository;

import com.example.jenkinsgit.jenkinsgit.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepository extends JpaRepository<Project, Integer> {
    
}