package com.example.servingwebcontent.database;    



import java.sql.*;
public class mySQLConn {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/myPatient", "sqluser", "password");
            Statement sta = conn.createStatement();
            ResultSet reset = sta.executeQuery("select * from patientRecord");
            System.out.println("reSEt"+reSet.toString());
            reSet.close();
            sta.close();
            conn.close();
        } catch (Exception e){ System.out.println(e);
        }
    }
}
