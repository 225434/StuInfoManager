package dao;

import dao.Implement.UserImplement;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao implements UserImplement {
    BaseDao baseDao = new BaseDao();
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public int add(User user) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "insert into 用户表 (账号,密码) value(?,?) ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getAccount());
        preparedStatement.setString(2, user.getPassword());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement, connection);
        return result;
    }

    @Override
    public int delete(String account) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "delete from 用户表 where 账号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account);
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement, connection);
        return result;
    }

    @Override
    public int update(User user) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "update 用户表 set 密码=?where 账号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getAccount());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement,connection);
        return result;
    }

    @Override
    public User search(String account) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "select * from 用户表 where 账号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String account_ = resultSet.getString("账号");
            String password = resultSet.getString("密码");
            resultSet.close();
            baseDao.close(preparedStatement, connection);
            return new User(account_, password);
        }
        return null;
    }

    @Override
    public ArrayList<User> searchAll() throws Exception {
        ArrayList<User> list = new ArrayList<>();
        connection = BaseDao.getConnection();
        String sql = "select * from 用户表";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String account_ = resultSet.getString("账号");
            String password = resultSet.getString("密码");
            list.add(new User(account_, password));
        }
        resultSet.close();
        baseDao.close(preparedStatement, connection);
        return list;
    }
}
