package com.xiong.mybatis.Mapper;

import com.xiong.mybatis.entry.Address;
import com.xiong.mybatis.entry.Student;

import java.util.List;

public interface AddressMapper {

        void addAdderssInfo(Address address);

        List<Address> queryAddressInfo();

        List<Address> queryAddressInfoByHashMap();

    List<Address> queryAddressInfoBySqlTap(Address address);

    List<Address>  queryAddressInfoWithProps(Address address);

    List<Address>   queryAddressInfoWithArray(int[] id);

     List<Address>   queryAddressInfoWithList(List<Integer> id);

    List<Address>  queryAddressInfoWithObjectArray(Student[] id);

     List<Address>   queryAddressInfoWithListObject(List<Student> id);

}
