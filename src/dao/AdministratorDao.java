package dao;

import dao.Implement.AdministratorImplement;
import entity.Administrator;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdministratorDao implements AdministratorImplement {
    BaseDao baseDao = new BaseDao();
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public int add(Administrator administrator) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "insert into 学生表 value (账号,密码)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, administrator.getAccount());
        preparedStatement.setString(2, administrator.getPassword());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement, connection);
        return result;
    }

    @Override
    public int delete(String account) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "delete from 管理员表 where 账号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account);
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement, connection);
        return result;
    }

    @Override
    public int update(Administrator administrator) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "update 管理员表 set 密码=?where 账号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, administrator.getPassword());
        preparedStatement.setString(2, administrator.getAccount());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement,connection);
        return result;
    }

    @Override
    public User search(String account) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "search * from 管理员表 where 账号=?";
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
    public ArrayList<Administrator> searchAll() throws Exception {
        ArrayList<Administrator> list = new ArrayList<>();
        connection = BaseDao.getConnection();
        String sql = "select * from 管理员表";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String account_ = resultSet.getString("学号");
            String password = resultSet.getString("姓名");
            list.add(new Administrator(account_, password));
        }
        resultSet.close();
        baseDao.close(preparedStatement, connection);
        return list;
    }
}
