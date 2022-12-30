package com.sustech.service_education.service.assignment;

import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    AssignmentMapper assignmentMapper;

    public Result addAssignment(int id, String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements) {
        assignmentMapper.addAssignment(id, title, course_id, teacher_id, due_date, resubmission_allowed, accept_resubmission_until, requirements);
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
        HashMap<String, Object> map = assignmentMapper.selectSubmissionById(assignment_id, student_id);
        if (map == null || map.size() == 0) throw new SourceNotFoundException();
        return Result.ok().code(200).data(map);
    }
}
