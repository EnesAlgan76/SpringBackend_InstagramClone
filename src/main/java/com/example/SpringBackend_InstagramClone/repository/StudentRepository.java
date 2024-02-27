package com.example.SpringBackend_InstagramClone.repository;


import com.example.SpringBackend_InstagramClone.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel,Integer> {
    
}
