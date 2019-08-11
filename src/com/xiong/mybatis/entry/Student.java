package com.xiong.mybatis.entry;

public class Student {

    private int stuId;
    private String stuName;
    private int stuAge;

    private StudentCourse coures;

    public Student() {
    }

    public Student(int stuId, String stuName, int stuAge) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public StudentCourse getCoures() {
        return coures;
    }

    public void setCoures(StudentCourse coures) {
        this.coures = coures;
    }

    @Override
    public String toString() {
        String  courseInfo = "";
        if(getCoures() !=null)
        {
            courseInfo = getCoures().toString();
        }
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}' +"====="+courseInfo;
    }
}
