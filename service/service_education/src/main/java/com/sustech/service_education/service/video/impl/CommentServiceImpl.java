package com.sustech.service_education.service.video.impl;

import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Comment;
import com.sustech.service_education.mapper.CommentMapper;
import com.sustech.service_education.service.video.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper mapper;

    @Override
    public Result postComment(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date) {
        int success = mapper.insertComment(content, father_comment_id, user_id, session_id, comment_date);
        if (success == 0) throw new DatabaseOperationFailureException();

        return Result.ok().code(200).message("评论发布成功");
    }

    @Override
    public Result postReply(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date, String reply_user_id) {
        int success = mapper.insertReply(content, father_comment_id, user_id, session_id, comment_date, reply_user_id);
        if (success == 0) throw new DatabaseOperationFailureException();

        return Result.ok().code(200).message("回复成功");
    }

    @Override
    public Result getComments(Integer session_id) {
        List<Comment> comments = mapper.getComments(session_id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("comments", comments);

        return Result.ok().code(200).message("获取评论成功").data(map);
    }
}
