package com.example.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.request.SampleJsonRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String secondQuery() {
        return "Second Query";
    }

    public String fullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }

    public String fullNameJson( SampleJsonRequest request ){
        return request.getFirstName()+ " " + request.getLastName();
    }
// whether method name is getStudent or student
// we need to write always student ( id : Long) : StudentResponse
    public StudentResponse student( long id){
        return new StudentResponse(studentService.getStudentById(id));
    }

}
