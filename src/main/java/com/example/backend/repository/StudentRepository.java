package com.example.backend.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.util.StringUtils;
import com.example.backend.AppException;
import com.example.backend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    public static ArrayList<Student> data = new ArrayList<>();
    public static int counter = 0;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Student> getAllStudent(){
        if(counter == 0) {
            Student s1 = new Student();
            s1.setDepartment("CloudEngineering");
            s1.setFirstName("Ajay");
            s1.setLastName("Singh");
            Student s2 = new Student();
            s2.setDepartment("CloudEngineering");
            s2.setFirstName("Rom");
            s2.setLastName("Solanki");
            data.add(s1);
            data.add(s2);
            counter ++;
        }
        return data;
    }


    public String saveStudent(Student s1){
       data.add(s1);
       return "SUCCESS";
    }


    public String addStudent(Student s1){
       dynamoDBMapper.save(s1);
        return "SUCCESS";
    }

    public Student getStudentById(String id){
        Student s = dynamoDBMapper.load(Student.class,id);
        if(s == null)
            throw new AppException("No Data Exist");
        return dynamoDBMapper.load(Student.class,id);
    }
}
