package com.xiong.mybatis.Test;

import com.xiong.mybatis.Mapper.StudentMapper;
import com.xiong.mybatis.entry.Student;
import com.xiong.mybatis.entry.StudentClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

         //addStudnetInfo(); 测试关联查询 在这个字段新添加了个字段
        //queryAllStudent();
       // updateStudentInfo();
       // delStudentInfo();
        //queryAllStudent();
        //queryStudnetInfoByParameterTypeHashMap();
       // queryStudnetInfoByReturnTypeHashMap();
        //queryStudentInfoAndCourseInfo();
       // queryStudentClassInfo();
         queryStudentClassInfoWithLazyLoad();

    }

    static void addStudnetInfo()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        Student student = new Student(2,"xiong",33);
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

    static void queryStudentInfoAndCourseInfo()
    {

        SqlSession sqlSession =  sqlSessionFactory.openSession();

        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        List<Student> list = studentMapper.queryStudentInfoAndCourseInfo(1);
        System.out.println(list);

    }


     static void     queryStudentClassInfo()
    {
                 SqlSession sqlSession =  sqlSessionFactory.openSession();
              StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

                List<StudentClass> list = studentMapper.queryStudentClassInfo(1);
                System.out.println(list);


    }


    static void    queryStudentClassInfoWithLazyLoad()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        StudentMapper studentMapper =  sqlSession.getMapper(StudentMapper.class);

        List<StudentClass> list = studentMapper.queryStudentClassInfoWithLazyLoad(1);
        System.out.println(list);

    }
}
