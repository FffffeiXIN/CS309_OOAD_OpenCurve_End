package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    Student selectStudentById(String id);

    void insert(Student student);

    List<Student> queryAllStudents();
    
    void updateStudent(Student student);
    
    void unblockStudent(String id);
    
    void blockStudent(String id);

    void update(String id,String name, String department, String college, String grade, String picture_url, String birthday, String gender, String region, String address);

    void updateOnline(String id);
    void updateOffline(String id);
}
