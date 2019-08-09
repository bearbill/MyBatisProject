package com.xiong.mybatis.entry;

import java.util.List;

public class Address {
    private int id;

    private String studentAddress;
    private String personAddress;
    private List<Integer> loveId;

    public Address() {
    }

    public Address(int id, String studentAddress, String personAddress) {
        this.id = id;
        this.studentAddress = studentAddress;
        this.personAddress = personAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }


    public List<Integer> getLoveId() {
        return loveId;
    }

    public void setLoveId(List<Integer> loveId) {
        this.loveId = loveId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", studentAddress='" + studentAddress + '\'' +
                ", personAddress='" + personAddress + '\'' +
                '}';
    }
}
