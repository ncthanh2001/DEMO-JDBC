package com.vitamin.DAO.DAOImpl;

import com.vitamin.DAO.CRUDOperations;
import com.vitamin.utils.Helper;
import com.vitamin.domain.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MentorDAO implements CRUDOperations<Mentor> {


    private static final String INSERT_MENTOR_SQL = "INSERT INTO mentor (mentor_id,fullname, age, gender) VALUES (?,?, ?, ?)";
    private static final String SELECT_MENTOR_BY_ID = "SELECT * FROM mentor WHERE mentor_id = ?";
    private static final String SELECT_ALL_MENTORS = "SELECT * FROM mentor";
    private static final String UPDATE_MENTOR_SQL = "UPDATE mentor SET fullname = ?, age = ?, gender = ? WHERE mentor_id = ?";
    private static final String DELETE_MENTOR_SQL = "DELETE FROM mentor WHERE mentor_id = ?";

    @Override
    public void create(Mentor mentor) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENTOR_SQL)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, mentor.getFullname());
            preparedStatement.setInt(2, mentor.getAge());
            preparedStatement.setBoolean(3, mentor.isGender());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Mentor> findById(int id) {
        Mentor mentor = null;
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENTOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                mentor = new Mentor();
                mentor.setMentorId(rs.getInt("mentor_id"));
                mentor.setFullname(rs.getString("fullname"));
                mentor.setAge(rs.getInt("age"));
                mentor.setGender(rs.getBoolean("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(mentor);
    }

    @Override
    public List<Mentor> findAll() {
        List<Mentor> mentors = new ArrayList<>();
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENTORS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setMentorId(rs.getInt("mentor_id"));
                mentor.setFullname(rs.getString("fullname"));
                mentor.setAge(rs.getInt("age"));
                mentor.setGender(rs.getBoolean("gender"));
                mentors.add(mentor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

    @Override
    public void update(Mentor mentor) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MENTOR_SQL)) {
            preparedStatement.setString(1, mentor.getFullname());
            preparedStatement.setInt(2, mentor.getAge());
            preparedStatement.setBoolean(3, mentor.isGender());
            preparedStatement.setInt(4, mentor.getMentorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MENTOR_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean insertMentors(List<Mentor> listMentors) {
        try (Connection connection = Helper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENTOR_SQL)) {
//            connection.setAutoCommit(false);
            for (Mentor item : listMentors) {
                preparedStatement.setInt(1,item.getMentorId());
                preparedStatement.setString(2, item.getFullname());
                preparedStatement.setInt(3, item.getAge());
                preparedStatement.setBoolean(4, item.isGender());
                preparedStatement.executeUpdate();
            }
//            connection.commit();
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
}
