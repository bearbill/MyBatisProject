package com.xiong.mybatis.Test;

import com.xiong.mybatis.Mapper.StudentMapper;
import com.xiong.mybatis.entry.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

         addStudnetInfo();
        //queryAllStudent();
       // updateStudentInfo();
       // delStudentInfo();
        //queryAllStudent();
        //queryStudnetInfoByParameterTypeHashMap();
        queryStudnetInfoByReturnTypeHashMap();

    }

    static void addStudnetInfo()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        Student student = new Student(1,"xiong",33);
        studentMapper.addStudnetInfo(student);
        sqlSession.commit();

    }

    static void queryAllStudent()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        Student student = new Student(1,"xiong",23);
        List<Student> list =  studentMapper.queryAllStudnetInfo();
        System.out.println(list);
    }


    static void updateStudentInfo()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(1,"xiong",35);
        studentMapper.updateStudentInfo(student);
        sqlSession.commit();

    }
    static void delStudentInfo()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        studentMapper.delStudentInfo(1);
        sqlSession.commit();
    }

    static void queryStudnetInfoByParameterTypeHashMap()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("name","weijun");
        List<Student> list = studentMapper.queryStudnetInfoByParameterTypeHashMap(map);
        System.out.println(list);
    }

    static void queryStudnetInfoByReturnTypeHashMap()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        List<HashMap<String,Object>> list = studentMapper.queryStudnetInfoByReturnTypeHashMap();
        System.out.println(list);
    }

}
