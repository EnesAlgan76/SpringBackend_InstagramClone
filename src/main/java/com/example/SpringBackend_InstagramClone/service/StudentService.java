package com.example.SpringBackend_InstagramClone.service;


import com.example.SpringBackend_InstagramClone.model.StudentModel;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.request_response.StudentRequest;

public interface StudentService {

    BaseResponse addStudent(StudentModel studentRequest);

    BaseResponse getAllStudents();

    BaseResponse getStudentById(int id);

    BaseResponse updateStudent(StudentRequest studentRequest);

    BaseResponse deleteStudent(int id);
    
}
