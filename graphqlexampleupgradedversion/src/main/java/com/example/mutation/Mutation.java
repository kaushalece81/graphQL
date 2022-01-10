package com.example.mutation;


import com.example.request.CreateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private StudentService studentService;

    public StudentResponse createStudent( CreateStudentRequest createStudentRequest ){
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
