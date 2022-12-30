package com.sustech.service_education.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface AssignmentMapper {

    void addAssignment(int id,String title,String course_id,String teacher_id,String due_date,int resubmission_allowed,String accept_resubmission_until,String requirements);

    void addStudentSubmission(int assignment_id,String student_id,String content_url,String text);

    HashMap<String,Object> selectSubmissionById(int assignment_id,String student_id);

    void updateStudentSubmission(int assignment_id,String student_id,String content_url,String text);

}
