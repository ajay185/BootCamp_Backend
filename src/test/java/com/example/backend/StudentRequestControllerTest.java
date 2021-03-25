package com.example.backend;

import com.example.backend.controller.StudentController;
import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StudentRequestControllerTest {

    @InjectMocks
    StudentController testController;

    @Mock
    StudentRepository testRepository;

    @Test
    public void when_getStudent_returns_valid_student(){
        Student mockedResponse = getMocketResponseFrom();
        Mockito.when(testRepository.getStudentById("03c4892d-3b94-49b4-90f0-d85ff5d1683f")).thenReturn(mockedResponse);
        Student result = testController.getStudentById("03c4892d-3b94-49b4-90f0-d85ff5d1683f");
        assertEquals(result,mockedResponse);
    }

    @Test
    public void when_getStudent_returns_invalid_student(){
        Student mockedResponse = getMocketResponseFrom();
        Mockito.when(testRepository.getStudentById("0")).thenThrow(new AppException("No Data Exist"));
        ResponseStatusException result = assertThrows(ResponseStatusException.class,()->{
            testController.getStudentById("0");
        });
        assertNotNull(result);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatus());
    }

    public Student getMocketResponseFrom(){
        Student student = new Student();
        student.setId("03c4892d-3b94-49b4-90f0-d85ff5d1683f");
        student.setFirstName("TEST");
        student.setLastName("SINGH");
        student.setDepartment("CLOUD");
        return student;
    }
}
