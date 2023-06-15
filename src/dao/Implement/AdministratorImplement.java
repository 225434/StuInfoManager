package dao.Implement;

import entity.Administrator;
import entity.User;

import java.util.ArrayList;

public interface AdministratorImplement {
    int add (Administrator administrator) throws Exception;//添加
    int delete (String account) throws Exception;//删除
    int update (Administrator administrator) throws Exception;//修改
    User search (String account) throws Exception;//查找
    ArrayList<Administrator> searchAll() throws Exception;//查看所有
}
