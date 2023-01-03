package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Comment;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment (content, father_comment_id, user_id, session_id, comment_date) values (" +
            "#{content}, #{father_comment_id}, #{user_id}, #{session_id}, #{comment_date})")
    int insertComment(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date);

    @Insert("insert into comment (content, father_comment_id, user_id, session_id, comment_date, reply_user_id) values (" +
            "#{content}, #{father_comment_id}, #{user_id}, #{session_id}, #{comment_date}, #{reply_user_id})")
    int insertReply(String content, Integer father_comment_id, String user_id, Integer session_id, String comment_date, String reply_user_id);

    @Select("select * from comment where session_id = #{session_id}")
    List<Comment> getComments(Integer session_id);
}
