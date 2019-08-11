package com.xiong.mybatis.Mapper;

import com.xiong.mybatis.entry.StudentClass;

import java.util.List;

public interface StudentClassMapper {

    List<StudentClass>  queryStudentClassInfoForLazyLoad(int id);
}
