package com.example.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.entity.Subject;
import com.example.enums.SubjectNameFilter;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
    // whenever consumer asks for LearningSubjects that time GraphQL calls this method
	// Note whenever there is business logic involved
	// which are not called by all consumers,
	// then write it in resolver only
/*    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse){
        List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}
		return learningSubjects;
	}*/

	// subject add datafilter
	public List<SubjectResponse> getLearningSubjects( StudentResponse studentResponse, SubjectNameFilter subjectNameFilter ){
		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
				// added if condition for data filter on subject
				if(subjectNameFilter.name().equalsIgnoreCase(SubjectNameFilter.All.name())){
					learningSubjects.add(new SubjectResponse(subject));
				}
				// added if condition for data filter on subject
				else if(subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())){
					learningSubjects.add(new SubjectResponse(subject));
				}

			}
		}
		return learningSubjects;
	}

	public String getFullName(StudentResponse studentResponse){
		return studentResponse.getFirstName()+ " " + studentResponse.getLastName();
	}
}
