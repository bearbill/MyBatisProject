package com.xiong.mybatis.Mapper;

import com.xiong.mybatis.entry.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//匹配过程
//1.根据接口名 找到 mapper.xml (根据 namespace=接口全类名
//2.接口的方法 找到 mapper.xml sql里面的标签id (接口名=sql ID)
//
//)
public interface StudentMapper {

     void addStudnetInfo(Student stu);
     void updateStudentInfo(Student stu);
     void delStudentInfo(int stuId);
     List<Student> queryAllStudnetInfo();
     List<Student> queryStudnetInfoByParameterTypeHashMap(Map<String, Object> map);
     List<HashMap<String,Object>> queryStudnetInfoByReturnTypeHashMap();

}
