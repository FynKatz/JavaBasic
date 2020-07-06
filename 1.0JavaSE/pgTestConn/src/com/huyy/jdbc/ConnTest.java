package com.huyy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnTest {
    public static void main(String args[]) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // 1.连接测试
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test/myshchema", 
                    "postgres", "123456");
            System.out.println("Opened database successfully");

            // 2.查找数据
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM myschema.company;");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
            }
            rs.close();//关闭查询
            stmt.close();//关闭statement
            conn.close();//关闭jdbc连接

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
