package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

    public static void main(String[] args) {

        Connection con = null; // DB접속을 위한 Connection 인스턴스를 만들기 위해 con 이라는 변수 선언

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 Driver 등록 (.forName을 쓰면 try/catch문으로)

            con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", "ohgiraffers", "ohgiraffers");
            // DriverManager를 이용해 Connection 생성 (url, id, password 입력), try/catch 를 이용해 SQLException 예외처리

            System.out.println("con = " + con);

        } catch (ClassNotFoundException e) {
            e.getException();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
