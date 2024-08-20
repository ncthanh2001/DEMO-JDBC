package com.vitamin.domain;

import com.vitamin.utils.Major;

public abstract class BaseStudents {
    protected String fullName;
    protected Integer age;
    protected Major major;

    protected Integer studentId;


    BaseStudents(String fullName, Integer age, Major major, Integer studentId) {
        this.fullName = fullName;
        this.age = age;
        this.major = major;
        this.studentId = studentId;
    }

    BaseStudents() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
