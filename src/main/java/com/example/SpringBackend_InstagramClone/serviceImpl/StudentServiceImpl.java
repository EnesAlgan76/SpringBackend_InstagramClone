package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.model.StudentModel;
import com.example.SpringBackend_InstagramClone.repository.StudentRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.request_response.StudentRequest;
import com.example.SpringBackend_InstagramClone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    public StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public BaseResponse addStudent(StudentModel studentRequest) {
        BaseResponse baseResponse = new BaseResponse();

        try {
            StudentModel s = new StudentModel();
            s.setStudentName(studentRequest.getStudentName());
            s.setStudentEmail(studentRequest.getStudentEmail());
            s.setStudentPassword(studentRequest.getStudentPassword());

            StudentModel studentModel = studentRepository.save(s);

            baseResponse.setStatus(true);
            baseResponse.setData(studentModel);
            baseResponse.setMessage("Student added successfully.");

        } catch (Exception e) {
            baseResponse.setStatus(false);
            baseResponse.setMessage("Student addition failed!");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse getAllStudents() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<StudentModel> allStudents = studentRepository.findAll();
            if (!allStudents.isEmpty()) {
                baseResponse.setData(allStudents);
                baseResponse.setMessage("All students");
                baseResponse.setStatus(true);
            } else {
                baseResponse.setMessage("No students");
                baseResponse.setStatus(false);
            }
        } catch (Exception e) {
            baseResponse.setMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse getStudentById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Optional<StudentModel> checkStudent = studentRepository.findById(id);
            if (checkStudent.isPresent()) {
                StudentModel s = checkStudent.get();
                baseResponse.setData(s);
                baseResponse.setMessage("Student details");
                baseResponse.setStatus(true);
            } else {
                baseResponse.setMessage("No student details");
                baseResponse.setStatus(false);
            }
        } catch (Exception e) {
            baseResponse.setMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse updateStudent(StudentRequest studentRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Optional<StudentModel> checkStudent = studentRepository.findById(studentRequest.getStudentId());
            if (checkStudent.isPresent()) {
                StudentModel s = checkStudent.get();
                s.setStudentName(studentRequest.getStudentName());
                s.setStudentEmail(studentRequest.getStudentEmail());
                s.setStudentPassword(studentRequest.getStudentPassword());
                StudentModel studentModel = studentRepository.save(s);

                baseResponse.setStatus(true);
                baseResponse.setMessage("Student updated successfully");
                baseResponse.setData(studentModel);

            } else {
                baseResponse.setStatus(false);
                baseResponse.setMessage("Student updation failed");
            }
        } catch (Exception e) {
            baseResponse.setStatus(false);
            baseResponse.setMessage(e.getMessage());
        }

        return baseResponse;
    }

    @Override
    public BaseResponse deleteStudent(int id) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Optional<StudentModel> checkStudent = studentRepository.findById(id);
            if (checkStudent.isPresent()) {
                StudentModel s = checkStudent.get();

                studentRepository.delete(s);

                baseResponse.setData(s);
                baseResponse.setStatus(true);
                baseResponse.setMessage("Student deleted successfully.");
            } else {
                baseResponse.setStatus(false);
                baseResponse.setMessage("Student deletion failed.");
            }
        } catch (Exception e) {
            baseResponse.setStatus(false);
            baseResponse.setMessage(e.getMessage());
        }
        return baseResponse;
    }

}
