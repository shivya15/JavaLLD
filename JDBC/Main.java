package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:postgresql:localhost:2400/demo";
        String username="postgres";
        String password="";
        String query="Select sname from student where sid==1";
        Connection connection=DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        ResultSet.next();
        String name=resultset.getString(sname);
        System.out.println(name);
        connection.close();
    }
}
