package com.tingyun;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class SparkServlet extends HttpServlet {
    private static String DATABASE_IP="192.168.2.129";
    private static final String INSERT_RECORD = "insert into test_user (id,name,birthday) values (1002, '≤‚ ‘“ª£§≤‚ ‘“ª','2012-08-26')";
    private static final String SELECT_ALL_RECORDS = "select id,name,birthday from test_user where name like '%\" + \"≤‚ ‘\" + \"%'";

    private static final String UPDATE_ALL_RECORDS = "update test_user set name='≤‚ ‘∂˛%^≤‚ ‘∂˛' where name = '≤‚ ‘“ª£§≤‚ ‘“ª'";

    private static final String DELETE_ALL_RECORDS = "delete from test_user where id=1002";
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DOCKER_CONTAINER_NAME = "db";
    private static final String DATABASE_NAME = "javatest";
    private static final String DATABASE_PORT = "3306";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "tingyun2o13";


    private Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName(MYSQL_DRIVER);
        return DriverManager.getConnection("jdbc:mysql://192.168.2.129:3306/javatest", DATABASE_USER,
                DATABASE_PASSWORD);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection2 = getConnection();
            Statement statement2 = connection2.createStatement();
            int num=statement2.executeUpdate(DELETE_ALL_RECORDS);
            System.err.print(num);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection connection3 = getConnection();
            Statement statement3 = connection3.createStatement();
            int num3=statement3.executeUpdate(INSERT_RECORD);
            System.err.print(num3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_RECORDS);
            while (rs.next()) {
                System.err.println(rs.getRow());
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection2 = getConnection();
            Statement statement2 = connection2.createStatement();
            int num=statement2.executeUpdate(UPDATE_ALL_RECORDS);
            System.err.print(num);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
