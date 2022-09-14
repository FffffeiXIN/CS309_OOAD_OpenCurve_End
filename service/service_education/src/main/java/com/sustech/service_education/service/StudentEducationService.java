package com.sustech.service_education.service;

import org.springframework.stereotype.Service;

public interface StudentEducationService {
    boolean chooseCourse(int id);

    boolean checkStudent(int id,String passwd);
}
