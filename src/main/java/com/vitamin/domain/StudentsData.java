package com.vitamin.domain;

import com.vitamin.utils.Major;

import java.math.BigDecimal;

public class StudentsData extends BaseStudents{

    private BigDecimal pointOracle;
    private BigDecimal pointMysql;
    private BigDecimal pointPostgresql;
    public StudentsData(){}
    public StudentsData(String fullName, Integer age, Major major, BigDecimal pointOracle, BigDecimal pointMysql, BigDecimal pointPostgresql,Integer studentId) {
        super(fullName, age, major,studentId);
        this.pointOracle = pointOracle;
        this.pointMysql = pointMysql;
        this.pointPostgresql = pointPostgresql;
    }

    public BigDecimal getPointOracle() {
        return pointOracle;
    }

    public void setPointOracle(BigDecimal pointOracle) {
        this.pointOracle = pointOracle;
    }

    public BigDecimal getPointMysql() {
        return pointMysql;
    }

    public void setPointMysql(BigDecimal pointMysql) {
        this.pointMysql = pointMysql;
    }

    public BigDecimal getPointPostgresql() {
        return pointPostgresql;
    }

    public void setPointPostgresql(BigDecimal pointPostgresql) {
        this.pointPostgresql = pointPostgresql;
    }

    @Override
    public String toString() {
        return "Name: "+this.fullName + " - " + this.major;
    }
}
