package com.xiong.mybatis.Main;


import com.xiong.mybatis.entry.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class ProjectAsMain {
    public static void main(String[] args) throws Exception{

        Reader reader = Resources.getResourceAsReader("mybatisconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person persion = sqlSession.selectOne("mapping.personMapper.selectOnePresonById",2);

        System.out.println(persion);
    }
}
