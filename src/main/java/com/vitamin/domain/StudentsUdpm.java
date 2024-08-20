package com.vitamin.domain;

import com.vitamin.utils.Major;

import java.math.BigDecimal;

public class StudentsUdpm extends BaseStudents{

    private BigDecimal pointJava1;
    private BigDecimal pointWeb;
    private BigDecimal pointJava2;

    public StudentsUdpm(){}

    public StudentsUdpm(String fullName, Integer age, Major major, BigDecimal pointJava1, BigDecimal pointWeb, BigDecimal pointJava2,Integer StudentsId) {
        super(fullName, age, major,StudentsId);
        this.pointJava1 = pointJava1;
        this.pointWeb = pointWeb;
        this.pointJava2 = pointJava2;
    }

    public BigDecimal getPointJava1() {
        return pointJava1;
    }

    public void setPointJava1(BigDecimal pointJava1) {
        this.pointJava1 = pointJava1;
    }

    public BigDecimal getPointWeb() {
        return pointWeb;
    }

    public void setPointWeb(BigDecimal pointWeb) {
        this.pointWeb = pointWeb;
    }

    public BigDecimal getPointJava2() {
        return pointJava2;
    }

    public void setPointJava2(BigDecimal pointJava2) {
        this.pointJava2 = pointJava2;
    }
}
