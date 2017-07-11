package com.tingyun;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by tingyun on 2017/6/15.
 */
public class Hadoop extends HttpServlet {
    private static final String INSERT_RECORD = "insert into test_user1 (id,name,birthday) values (1001, 'Hessian是一个轻量级的remoting onhttp工具，使用简单的方法提供了RMI的功能。 相比WebService，Hessian更简单、快捷。采用的是二进制RPC协议，因为采用的是二进一￥测试一',to_char(sysdate,'YYYY-MM-DD HH24:MI:SS'))";
    private static final String SELECT_ALL_RECORDS = "select id,name,birthday from test_user1 where name like '%\" + \"测试\" + \"%'";

    private static final String UPDATE_ALL_RECORDS = "update test_user1 set name='测试二%^测试二' where name = '测试一￥测试一'";

    private static final String DELETE_ALL_RECORDS = "delete from test_user1 where id=1001";
    private static final String MYSQL_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_USER = "system";
    private static final String DATABASE_PASSWORD = "nbs2o13";


    private Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName(MYSQL_DRIVER);
        return DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.2:1521:orcl", DATABASE_USER,
                DATABASE_PASSWORD);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection2 = getConnection();
            Statement statement2 = connection2.createStatement();
            int num = statement2.executeUpdate(DELETE_ALL_RECORDS);
            System.err.print(num);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection connection3 = getConnection();
            Statement statement3 = connection3.createStatement();
            int num3 = statement3.executeUpdate(INSERT_RECORD);
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
            int num = statement2.executeUpdate(UPDATE_ALL_RECORDS);
            System.err.print(num);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
