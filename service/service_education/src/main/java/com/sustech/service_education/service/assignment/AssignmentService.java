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
import java.util.Map;

@Service
public class AssignmentService {
    @Autowired
    AssignmentMapper assignmentMapper;

    public Result addAssignment(String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements, String attachment) {
        assignmentMapper.addAssignment(title, course_id, teacher_id, due_date, resubmission_allowed, accept_resubmission_until, requirements, attachment);
        return Result.ok().code(200);
    }

    public Result submitAssignment(int assignment_id, String student_id, String text, String content_url, String submission_date) {
        if (assignmentMapper.selectSubmissionById(assignment_id, student_id) == null) {
            assignmentMapper.addStudentSubmission(assignment_id, student_id, content_url, text, submission_date);
            return Result.ok().code(200).message("新建提交成功");
        }
        assignmentMapper.updateStudentSubmission(assignment_id, student_id, content_url, text, submission_date);
        return Result.ok().code(200).message("更新提交成功");
    }

    public Result getSubmission(int assignment_id, String student_id) {
        Submission sub = assignmentMapper.selectSubmissionById(assignment_id, student_id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("submission", sub);
        return Result.ok().code(200).data(map);
    }

    public List<Assignment> getStudentAssignment(String student_id) {
        return assignmentMapper.getStudentAssignment(student_id);
    }

    public List<Assignment> getTeacherAssignment(String teacher_id) {
        return assignmentMapper.getTeacherAssignment(teacher_id);
    }

    public Result updateScore(int assignment_id, String student_id, double score) {
        assignmentMapper.updateScore(assignment_id, student_id, score);
        return Result.ok().code(200).message("打分成功");
    }

    public Result getAssignmentById(int id) {
        Assignment assi = assignmentMapper.getAssignmentByID(id);
        Map<String, Object> map = new HashMap<>();
        map.put("assignment", assi);

        return Result.ok().code(200).message("获取作业列表成功").data(map);
    }

    public Result getSubmissionsOfAssignment(int id) {
        Map<String, Object> map = new HashMap<>();
        List<Submission> subs = assignmentMapper.selectSubmissionByAssId(id);
        map.put("submissions", subs);

        return Result.ok().code(200).message("获取学生提交成功").data(map);
    }

    public Result updateAssignment(int assignment_id, String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements, String attachment) {
        assignmentMapper.updateAssignment(assignment_id, title, course_id, teacher_id, due_date, resubmission_allowed, accept_resubmission_until, requirements, attachment);
        return Result.ok().code(200).message("修改成功");
    }

}
