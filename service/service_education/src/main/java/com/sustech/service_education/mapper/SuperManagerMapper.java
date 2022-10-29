package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.SuperManager;
import com.sustech.service_education.entity.Teacher;

import java.util.List;

public interface SuperManagerMapper {
    SuperManager selectManagerById(int id);

    void insert(SuperManager Manager);

    List<SuperManager> queryAllManagers();

    void updateManager(SuperManager Manager);
}
