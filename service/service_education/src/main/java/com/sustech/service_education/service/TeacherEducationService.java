package com.sustech.service_education.service;


import com.sustech.service_education.entity.Course;
import com.sustech.service_education.entity.Department;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.entity.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherEducationService {

    boolean delete(Teacher teacher);

    boolean delete(int id);

    boolean add(Teacher teacher);

    List<Teacher> queryAll();

    boolean register(User user);

}
