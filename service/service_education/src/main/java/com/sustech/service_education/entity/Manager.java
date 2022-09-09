package com.sustech.service_education.entity;

public interface Manager {

    boolean addTeacher(User user);

    boolean addStudent(User user);

    boolean delete(User user);

    boolean addCourse(Course course);

    boolean delete(Course course);

    boolean addDepartment(Department department);

    boolean delete(Department department);

}
