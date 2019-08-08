package com.xiong.mybatis.TypeHandler;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanToIntConverter extends BaseTypeHandler<Boolean> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean b, JdbcType jdbcType) throws SQLException {

       if(b)
       {
           preparedStatement.setInt(i,1);
       }
       else
       {
           preparedStatement.setInt(i,0);
       }
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int num = resultSet.getInt(s);

        return num ==1?true:false;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int num = resultSet.getInt(i);

        return num ==1?true:false;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int num = callableStatement.getInt(i);

        return num ==1?true:false;
    }
}
