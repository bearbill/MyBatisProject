package com.xiong.mybatis.Test;

import com.xiong.mybatis.Mapper.AddressMapper;
import com.xiong.mybatis.Mapper.StudentMapper;
import com.xiong.mybatis.entry.Address;
import com.xiong.mybatis.entry.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AddressTest {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //queryAddressInfo();
        //addAddressInfo();
        queryAddressInfoByHashMap();
       // queryAddressInfoBySqlTap();
       // queryAddressInfoWithProps();
        //queryAddressInfoWithArray();
        //queryAddressInfoWithList();
        //queryAddressInfoWithObjectArray();
       // queryAddressInfoWithListObject();
    }


    static void addAddressInfo()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);

        Address address = new Address(3,"xz","beij");
        addressMapper.addAdderssInfo(address);
        sqlSession.commit();

    }

    static void queryAddressInfo()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);

        List<Address> list =  addressMapper.queryAddressInfo();
        System.out.println(list);



        SqlSession sqlSession2 =  sqlSessionFactory.openSession();

        AddressMapper addressMapper2 =  sqlSession2.getMapper(AddressMapper.class);

        List<Address> list2 =  addressMapper2.queryAddressInfo();
        System.out.println(list2);

    }

    static void  queryAddressInfoByHashMap()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);

        List<Address> list =  addressMapper.queryAddressInfoByHashMap();
        System.out.println(list);
        sqlSession.clearCache();

        System.out.println("一级缓存查看");
        addressMapper.updateAddressInfo(1);
       // sqlSession.commit();
        List<Address> list2 =  addressMapper.queryAddressInfoByHashMap();
        System.out.println(list2);

        System.out.println("二级缓存查看");
        //sqlSession.close();
        SqlSession sqlSession2 =  sqlSessionFactory.openSession();

        AddressMapper addressMapper2 =  sqlSession2.getMapper(AddressMapper.class);

        List<Address> list3 =  addressMapper2.queryAddressInfoByHashMap();
        System.out.println(list3);
    }

    static void queryAddressInfoBySqlTap()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);

        Address address = new Address(1,"cq","");

        List<Address> list =  addressMapper.queryAddressInfoBySqlTap(address);
        System.out.println(list);
    }

    static void queryAddressInfoWithProps()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        Address address = new Address();
        address.setLoveId(list);

        List<Address> loveList =  addressMapper.queryAddressInfoWithProps(address);
        System.out.println(loveList);
    }


    static void queryAddressInfoWithArray()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);


        int[] id = {1,3};
        List<Address> loveList =  addressMapper.queryAddressInfoWithArray(id);
        System.out.println(loveList);
    }

    static void queryAddressInfoWithList()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);


        List<Integer> id = new ArrayList<>();
        id.add(1);
        id.add(4);
        List<Address> loveList =  addressMapper.queryAddressInfoWithList(id);
        System.out.println(loveList);
    }


    static void queryAddressInfoWithObjectArray()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);



        Student st1 = new Student();
        st1.setStuId(1);
        Student st2 = new Student();
        st2.setStuId(4);

        Student[] id = new Student[]{st1,st2};

        List<Address> loveList =  addressMapper.queryAddressInfoWithObjectArray(id);
        System.out.println(loveList);
    }

    static void queryAddressInfoWithListObject()
    {
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        AddressMapper addressMapper =  sqlSession.getMapper(AddressMapper.class);

        Student st1 = new Student();
        st1.setStuId(1);
        Student st2 = new Student();
        st2.setStuId(4);

        List<Student> id = new ArrayList<>();
        id.add(st1);
        id.add(st2);
        List<Address> loveList =  addressMapper.queryAddressInfoWithListObject(id);
        System.out.println(loveList);
    }

}
