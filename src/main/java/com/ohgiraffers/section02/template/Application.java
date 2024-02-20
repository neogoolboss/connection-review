package com.ohgiraffers.section02.template;

import java.sql.Connection;

import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection(); // JDBCTemplate 클래스에 만들어 둔 getConnection메서드는 static 메서드

        System.out.println("con = " + con);

        close(con); // static 메서드라 이와 같이 호출 가능

    }

}
