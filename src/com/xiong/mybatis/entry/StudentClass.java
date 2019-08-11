package com.xiong.mybatis.entry;

import java.util.List;

public class StudentClass {
    private int classId;
    private String classInfo;
    private List<Student> list;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {

        String listInfo = "";
        for(Student student:getList())
        {
            listInfo += student.toString()+"---";
        }
        return "StudentClass{" +
                "classId=" + classId +
                ", classInfo='" + classInfo + '\'' +
                '}' + listInfo;
    }
}
