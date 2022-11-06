package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.SuperManager;
import com.sustech.service_education.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SuperManagerMapper {
    SuperManager selectManagerById(String id);

    void insert(SuperManager Manager);

    List<SuperManager> queryAllManagers();

    void updateManager(SuperManager Manager);
}
