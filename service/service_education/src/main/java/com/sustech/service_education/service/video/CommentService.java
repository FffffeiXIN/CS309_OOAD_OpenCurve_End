package com.sustech.service_education.service.video;

import com.sustech.commonutils.Result;

public interface CommentService {

    Result postComment(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date);

    Result postReply(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date, String reply_user_id);

    Result getComments(Integer sessionId);
}
