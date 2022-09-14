package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Student;
import java.util.List;

public interface StudentMapper {
    Student select(int id);
    
    List<Student> queryAll();
}
