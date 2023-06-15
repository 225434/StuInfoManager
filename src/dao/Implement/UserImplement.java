package dao.Implement;

import entity.User;

import java.util.ArrayList;

public interface UserImplement {
    int add (User user) throws Exception;//添加
    int delete (String string) throws Exception;//删除
    int update (User user) throws Exception;//修改
    User search (String account) throws Exception;//查找
    ArrayList<User> searchAll() throws Exception;//查看所有
}
