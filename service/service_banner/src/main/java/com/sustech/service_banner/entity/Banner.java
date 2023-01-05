package com.sustech.service_banner.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
public class Banner {
    String url;
    String course_id;
}
