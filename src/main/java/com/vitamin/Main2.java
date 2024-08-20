package com.vitamin;

import java.sql.*;

public class Main2 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/VitamincodeTrainingCourse";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       try{
           Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
           if(conn != null)
               System.out.println("Kết nối thành công");
           else
               System.out.println("Kết nối không thành công");

           String sql = "select mentor_id as mentor, fullname, age, gender from mentor ";
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

           while(rs.next())
           {
//               System.out.println("mentorId: "+ rs.getString("mentor")
//                        + " fullname: "+ rs.getString("fullname")
//                        + " age: "+rs.getString("age")
//                        + " gender: "+(rs.getInt("gender") == 0 ? "Nam ": "Nữ" ) );
//               System.out.println("----------------------");
//
//               System.out.println("mentorId: "+ rs.getString(1)
//                       + " fullname: "+ rs.getString(2)
//                       + " age: "+rs.getString(3)
//                       + " gender: "+(rs.getInt(4) == 0 ? "Nam ": "Nữ" ));
//               System.out.println("----------------------");
           }

           String sql2 = "select mentor_id as mentor, fullname, age, gender from mentor  where mentor_id = ? or fullname like ? " + "";
           PreparedStatement pstmt = conn.prepareStatement(sql2);
           pstmt.setInt(1,1);
           pstmt.setString(2,"Nguyễn Chí Thanh");
           rs = pstmt.executeQuery();
           while(rs.next())
           {
               System.out.println("mentorId: "+ rs.getString("mentor")
                       + " fullname: "+ rs.getString("fullname")
                       + " age: "+rs.getString("age")
                       + " gender: "+(rs.getInt("gender") == 0 ? "Nam ": "Nữ" ) );
               System.out.println("----------------------");

           }


           StringBuilder sql1 = new StringBuilder("select * from mentor");
           sql1.append(" where mentorId = ? ");


            sql1 = new StringBuilder("");
       }catch (Exception e)
       {
           System.out.println(e.getMessage());
       }



    }
}
