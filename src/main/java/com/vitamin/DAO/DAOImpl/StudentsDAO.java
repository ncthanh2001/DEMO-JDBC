package com.vitamin.DAO.DAOImpl;

import com.vitamin.DAO.CRUDOperations;
import com.vitamin.utils.Helper;
import com.vitamin.domain.StudentsData;
import com.vitamin.utils.Major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentsDAO implements CRUDOperations<StudentsData> {

    private static final String INSERT_STUDENT_SQL = "INSERT INTO students (fullname, age, major, point_oracle, point_mysql, point_posgresql) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE student_id = ?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String UPDATE_STUDENT_SQL = "UPDATE students SET fullname = ?, age = ?, major = ?, point_java1 = ?, point_web = ?, point_java2 = ?, point_oracle = ?, point_mysql = ?, point_posgresql = ? WHERE student_id = ?";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM students WHERE student_id = ?";

    @Override
    public void create(StudentsData student) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getMajor().name());
            preparedStatement.setBigDecimal(4, student.getPointOracle());
            preparedStatement.setBigDecimal(5, student.getPointMysql());
            preparedStatement.setBigDecimal(6, student.getPointPostgresql());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<StudentsData> findById(int id) {
        StudentsData student = null;
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                student = new StudentsData();
                student.setStudentId(rs.getInt("student_id"));
                student.setFullName(rs.getString("fullname"));
                student.setAge(rs.getInt("age"));
                student.setMajor(Major.UDPM.valueOf(rs.getString("major")));
                student.setPointOracle(rs.getBigDecimal("point_oracle"));
                student.setPointMysql(rs.getBigDecimal("point_mysql"));
                student.setPointPostgresql(rs.getBigDecimal("point_posgresql"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(student);
    }

    @Override
    public List<StudentsData> findAll() {
        List<StudentsData> students = new ArrayList<>();
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                StudentsData student = new StudentsData();
                student.setStudentId(rs.getInt("student_id"));
                student.setFullName(rs.getString("fullname"));
                student.setAge(rs.getInt("age"));
                student.setMajor(Major.valueOf(rs.getString("major")));
                student.setPointOracle(rs.getBigDecimal("point_oracle"));
                student.setPointMysql(rs.getBigDecimal("point_mysql"));
                student.setPointPostgresql(rs.getBigDecimal("point_posgresql"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void update(StudentsData student) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getMajor().name());
            preparedStatement.setBigDecimal(7, student.getPointOracle());
            preparedStatement.setBigDecimal(8, student.getPointMysql());
            preparedStatement.setBigDecimal(9, student.getPointPostgresql());
            preparedStatement.setInt(10, student.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean insertMentors(List<StudentsData> listMentors) {
        return null;
    }
}