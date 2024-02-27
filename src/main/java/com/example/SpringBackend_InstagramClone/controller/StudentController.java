package com.example.SpringBackend_InstagramClone.controller;

import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.request_response.StudentRequest;
import com.example.SpringBackend_InstagramClone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    public StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<BaseResponse> addStudent(@RequestBody StudentRequest studentRequest){
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = studentService.addStudent(studentRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<BaseResponse> getAllStudents(){
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = studentService.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @GetMapping("/getAllStudents/{id}")
    public ResponseEntity<BaseResponse> getStudentById(@PathVariable int id){
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = studentService.getStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<BaseResponse> updateStudent(@RequestBody StudentRequest studentRequest){
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = studentService.updateStudent(studentRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @GetMapping("/deleteStudent/{id}")
    public ResponseEntity<BaseResponse> deleteStudent(@PathVariable int id){
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = studentService.deleteStudent(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

}
