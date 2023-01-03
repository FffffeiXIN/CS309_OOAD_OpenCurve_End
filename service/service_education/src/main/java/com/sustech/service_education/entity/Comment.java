package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Comment {

    private Integer id;
    private String content;
    private Integer father_comment_id;
    private String user_id;
    private Integer session_id;
    private String comment_date;
    private String reply_user_id;
}
