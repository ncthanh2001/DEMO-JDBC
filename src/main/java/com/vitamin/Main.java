package com.vitamin;

import com.vitamin.DAO.DAOImpl.MentorDAO;
import com.vitamin.DAO.DAOImpl.StudentsDAO;
import com.vitamin.domain.Mentor;
import com.vitamin.domain.StudentsData;
import com.vitamin.utils.Helper;
import com.vitamin.utils.Major;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        MentorDAO mentorDAO = new MentorDAO();
        StudentsDAO studentsDAO = new StudentsDAO();

        Mentor mentor1 = new Mentor(10,"Nguyen van A", 10,true);
        Mentor mentor2 = new Mentor(11,"Nguyen van B", 10,true);
        Mentor mentor3 = new Mentor(5,"Nguyen van C", 10,true);
        List<Mentor> mentors  = new ArrayList<>();
        mentors.add(mentor1);
        mentors.add(mentor2);
        mentors.add(mentor3);


        System.out.println(mentorDAO.insertMentors(mentors));



//        StudentsData sv1 = new StudentsData("Nguyễn Chí Thanh123", 23, Major.DATA,
//                new BigDecimal(10), new BigDecimal(10), new BigDecimal(10),12);
//
//        studentsDAO.create(sv1);
//
//        List<StudentsData> listStudent = studentsDAO.findAll();
//
//        for (StudentsData item : listStudent)
//        {
//            System.out.println(item);
//        }

//        List<Mentor> listMentor = mentorDAO.findAll();
//
//        for (Mentor item : listMentor)
//        {
//            System.out.println(item);
//        }



//        try {
//
//            Connection connection = Helper.getConnection();
//
//            CallableStatement callableStatement = connection.prepareCall("CALL GetHello(?)");
//            callableStatement.registerOutParameter(1, Types.VARCHAR);
//            System.out.println();
//            callableStatement.execute();
//            System.out.println(callableStatement.getString("keyworld"));



//            String sql = "{CALL GetMentorById(?, ?, ?, ?)}";
//            CallableStatement callableStatement = connection.prepareCall(sql);
//
//            // Set input parameter
//            callableStatement.setInt(1, 2);
//
//            callableStatement.registerOutParameter(2, Types.VARCHAR);
//            callableStatement.registerOutParameter(3, Types.INTEGER);
//            callableStatement.registerOutParameter(4, Types.TINYINT);
//
//            // Execute stored procedure
//            callableStatement.execute();
//
//            // Retrieve output parameters
//            String fullname = callableStatement.getString(2);
//            int age = callableStatement.getInt(3);
//            boolean gender = callableStatement.getBoolean(4);
//
//            System.out.println("Full Name: " + fullname);
//            System.out.println("Age: " + age);
//            System.out.println("Gender: " + (gender ? "Male" : "Female"));
//        }catch (SQLException e)
//        {
//            e.printStackTrace();
//        }



    }
}
