package dao;

import entity.Journal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JournalDao {
    BaseDao baseDao = new BaseDao();
    private Connection connection;
    private PreparedStatement preparedStatement;

    public int add(Journal journal) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "insert into 日志 (日期,时间,操作者,操作) values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,journal.getData());
        preparedStatement.setString(2, journal.getTime());
        preparedStatement.setString(3, journal.getOperator());
        preparedStatement.setString(4, journal.getAction());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement,connection);
        return result;
    }

    public ArrayList<Journal> searchAll() throws Exception {
        ArrayList<Journal> list = new ArrayList<>();
        connection = BaseDao.getConnection();
        String sql = "select * from 日志";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String date = resultSet.getString("日期");
            String time = resultSet.getString("时间");
            String operator = resultSet.getString("操作者");
            String action = resultSet.getString("操作");
            list.add(new Journal(date,time,operator,action));
        }
        resultSet.close();
        baseDao.close(preparedStatement,connection);
        return list;
    }
}
