package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Assignment;
import com.sustech.service_education.entity.Submission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AssignmentMapper {

    void addAssignment(String title,String course_id,String teacher_id,String due_date,int resubmission_allowed,String accept_resubmission_until,String requirements,String attachment);

    void addStudentSubmission(int assignment_id,String student_id,String content_url,String text, String submission_date);

    Submission selectSubmissionById(int assignment_id, String student_id);

    void updateStudentSubmission(int assignment_id,String student_id,String content_url,String text, String submission_date);

    @Select("select * from assignment_list where course_id in (select course_id from student_course where student_id = #{student_id})")
    List<Assignment> getStudentAssignment(String student_id);

    @Select("select * from assignment_list where teacher_id = #{teacher_id}")
    List<Assignment> getTeacherAssignment(String teacher_id);

    @Update("update student_assignment set score = #{score} where assignment_id = #{assignment_id} and student_id = #{student_id}")
    void updateScore(int assignment_id,String student_id,double score);

    List<Submission> selectSubmissionByAssId(Integer assignment_id);

    @Select("select * from assignment_list where id = #{id}")
    Assignment getAssignmentByID(Integer id);

    void updateAssignment(int assignment_id, String title,String course_id,String teacher_id,String due_date,int resubmission_allowed,String accept_resubmission_until,String requirements,String attachment);
}
