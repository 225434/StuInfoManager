package dao;

import dao.Implement.StudentImplement;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao implements StudentImplement {
    BaseDao baseDao = new BaseDao();
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public int add(Student student) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "insert into 学生表 (学号,姓名,性别,专业) values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,student.getId());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setString(3,student.getSex());
        preparedStatement.setString(4,student.getMajor());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement,connection);
        return result;
    }

    @Override
    public int delete(String id) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "delete from 学生表 where 学号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement,connection);
        return result;
    }

    @Override
    public int update(Student student) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "update 学生表 set 姓名=?,性别=?,专业=?where 学号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getSex());
        preparedStatement.setString(3,student.getMajor());
        preparedStatement.setString(4,student.getId());
        int result = preparedStatement.executeUpdate();
        baseDao.close(preparedStatement,connection);
        return result;
    }

    @Override
    public Student search(String id) throws Exception {
        connection = BaseDao.getConnection();
        String sql = "select * from 学生表 where 学号=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            String id_ = resultSet.getString("学号");
            String name = resultSet.getString("姓名");
            String sex = resultSet.getString("性别");
            String major = resultSet.getString("专业");
            resultSet.close();
            baseDao.close(preparedStatement,connection);
            return new Student(id_,name,sex,major);
        }
        return null;
    }

    @Override
    public ArrayList<Student> searchAll() throws Exception {
        ArrayList<Student> list = new ArrayList<>();
        connection = BaseDao.getConnection();
        String sql = "select * from 学生表";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id_ = resultSet.getString("学号");
            String name = resultSet.getString("姓名");
            String sex = resultSet.getString("性别");
            String major = resultSet.getString("专业");
            list.add(new Student(id_,name,sex,major));
        }
        resultSet.close();
        baseDao.close(preparedStatement,connection);
        return list;
    }
}
