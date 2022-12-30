package com.sustech.service_education.service.assignment;

import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Assignment;
import com.sustech.service_education.entity.Submission;
import com.sustech.service_education.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    AssignmentMapper assignmentMapper;

    public Result addAssignment(int id, String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements,String attachment) {
        assignmentMapper.addAssignment(id, title, course_id, teacher_id, due_date, resubmission_allowed, accept_resubmission_until, requirements,attachment);
        return Result.ok().code(200);
    }

    public Result submitAssignment(int assignment_id, String student_id, String text, List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        list.forEach(x -> stringBuffer.append(x).append(","));
        if (assignmentMapper.selectSubmissionById(assignment_id, student_id).size() == 0) {
            assignmentMapper.addStudentSubmission(assignment_id, student_id, stringBuffer.toString(), text);
            return Result.ok().code(200).message("新建提交成功");
        }
        assignmentMapper.updateStudentSubmission(assignment_id, student_id, stringBuffer.toString(), text);
        return Result.ok().code(200).message("更新提交成功");
    }

    public Result getSubmission(int assignment_id, String student_id) {
        List<Submission> list = assignmentMapper.selectSubmissionById(assignment_id, student_id);
        HashMap<String,Object> map=new HashMap<>();
        map.put("submission",list);
        return Result.ok().code(200).data(map);
    }

    public List<Assignment> getStudentAssignment(String student_id){
        return assignmentMapper.getStudentAssignment(student_id);
    }

    public List<Assignment> getTeacherAssignment(String teacher_id){
        return assignmentMapper.getTeacherAssignment(teacher_id);
    }

    public Result updateScore(int assignment_id,String student_id,double score){
        assignmentMapper.updateScore(assignment_id,student_id,score);
        return Result.ok().code(200);
    }

}
