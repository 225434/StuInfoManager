package dao.Implement;

import entity.Student;

import java.util.ArrayList;

public interface StudentImplement {
    int add (Student student) throws Exception;//添加
    int delete (String string) throws Exception;//删除
    int update (Student student) throws Exception;//修改
    Student search (String id) throws Exception;//查找
    ArrayList<Student> searchAll() throws Exception;//查看所有
}
