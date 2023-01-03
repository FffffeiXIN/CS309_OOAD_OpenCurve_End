package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.video.CommentService;
import com.sustech.service_education.service.video.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/postComment")
    public Result postComment(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date) {
        return commentService.postComment(content, father_comment_id, user_id, session_id, comment_date);
    }

    @PostMapping("/postReply")
    public Result postReply(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date, String reply_user_id) {
        return commentService.postReply(content, father_comment_id, user_id, session_id, comment_date, reply_user_id);
    }

    @GetMapping("/getComments")
    public Result getComments(Integer session_id) {
        return commentService.getComments(session_id);
    }
}
