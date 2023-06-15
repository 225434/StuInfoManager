package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BaseDao {
    public static final String url = "jdbc:mysql://localhost:3306/学生信息管理系统";
    public static final String username = "root";
    public static final String password = "111111";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,username,password);
    }

    public void close(PreparedStatement preparedStatement, Connection connection) throws Exception{
        if(preparedStatement != null)
            preparedStatement.close();
        if (connection != null)
            connection.close();
    }
}
