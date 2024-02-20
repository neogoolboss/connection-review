package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {

    public static void main(String[] args) {

        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            /* JDBC 드라이버 로드 */
            Class.forName(driver); // add catch로 ClassNotFoundException 예외처리

            con = DriverManager.getConnection(url, user, password);
            // Application과 다른점은 위에서 변수설정을 했기 때문, add catch로 SQLException 예외처리

            System.out.println("con = " + con);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // 연결 및 리소스 해제! 자원 반납을 위해 finally 필수!
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
