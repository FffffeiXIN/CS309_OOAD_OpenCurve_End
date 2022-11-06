package com.sustech.service_education.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Video {

    String course_id;
    Integer session;
    String title;
    String url;
    String description;
}
