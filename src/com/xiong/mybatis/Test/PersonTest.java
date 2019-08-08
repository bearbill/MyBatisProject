package com.xiong.mybatis.Test;

import com.xiong.mybatis.entry.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class PersonTest {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

       // queryOnePersonById();
       // queryAllPersons();
       // updatePersonByAge();
      //  queryOnePersonById();
        //addPerson();
      //  queryAllPersons();
       // deletePersonInfoById();
       // queryAllPersons();


    }

    public static void deletePersonInfoById()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int  count=  sqlSession.update("mapping.personMapper.deletePersonInfoById",3);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);
    }
    public static void addPerson()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person addPerson = new Person(3,"jiajia",18);
        int  count=  sqlSession.update("mapping.personMapper.addPerson",addPerson);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);
    }

    public static void updatePersonByAge()
    {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person updatePerson = new Person(1,"",66);
         int  low=  sqlSession.update("mapping.personMapper.updatePersonByAge",updatePerson);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(low);
    }
    public static void queryOnePersonById()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person persion = sqlSession.selectOne("mapping.personMapper.selectOnePresonById",1);
        System.out.println(persion);
    }
    public static void  queryAllPersons()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "mapping.personMapper.queryAllPersons";
        List<Person> list = sqlSession.selectList(statement);
        System.out.println(list);
    }
}
