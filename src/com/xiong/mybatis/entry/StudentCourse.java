package com.xiong.mybatis.entry;

public class StudentCourse {

    private int courseId;
    private String courseInfo;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "courseId=" + courseId +
                ", courseInfo='" + courseInfo + '\'' +
                '}';
    }
}
