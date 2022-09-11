package com.sustech.service_education.entity;

public class SuperManager implements Manager{
    @Override
    public boolean addTeacher(User user) {
        return false;
    }

    @Override
    public boolean addStudent(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        return false;
    }

    @Override
    public boolean delete(Course course) {
        return false;
    }

    @Override
    public boolean addDepartment(Department department) {
        return false;
    }

    @Override
    public boolean delete(Department department) {
        return false;
    }
}
