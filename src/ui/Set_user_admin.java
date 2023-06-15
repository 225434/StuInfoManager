package ui;

import dao.AdministratorDao;
import dao.UserDao;
import entity.Administrator;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class Set_user_admin extends BaseFrameSet{
    public void open() {
        //界面设置
        JFrame UAFrame = new JFrame("用户/管理员设置");
        UAFrame.setResizable(false);
        UAFrame.setLayout(gridLayout4);
        UAFrame.setSize(600, 400);
        UAFrame.setLocationRelativeTo(null);
        UAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UAFrame.setBackground(Color.GRAY);
        //第一层面板
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel("账号：");
        JTextField jTextField1 = new JTextField();
        jLabel1.setFont(Label_font);
        jTextField1.setPreferredSize(TextField_dimension);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        //第二层面版
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel("密码：");
        JTextField jTextField2 = new JTextField();
        jLabel2.setFont(Label_font);
        jTextField2.setPreferredSize(TextField_dimension);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        //第三层面板
        JPanel jPanel3 = new JPanel();
        JButton jButton1 = new JButton("添加");
        JButton jButton2 = new JButton("删除");
        JButton jButton3 = new JButton("修改");
        JButton jButton4 = new JButton("查看");
        jButton1.setFont(Label_font);
        jButton1.setBackground(Button_color);
        jButton1.setSize(Button_dimension);
        jButton2.setFont(Label_font);
        jButton2.setBackground(Button_color);
        jButton2.setSize(Button_dimension);
        jButton3.setFont(Label_font);
        jButton3.setBackground(Button_color);
        jButton3.setSize(Button_dimension);
        jButton4.setFont(Label_font);
        jButton4.setBackground(Button_color);
        jButton4.setSize(Button_dimension);
        JButton jButton5 = new JButton("返回");
        jButton5.setFont(Label_font);
        jButton5.setBackground(Button_color);
        jButton5.setSize(Button_dimension);
        jButton1.addActionListener(e -> {
            try {
                new UserDao().add(new User(jTextField1.getText(),jTextField2.getText()));
                new AdministratorDao().add(new Administrator(jTextField1.getText(),jTextField2.getText()));
                JOptionPane.showMessageDialog(UAFrame,"添加成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UAFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton2.addActionListener(e -> {
            try {
                new UserDao().delete(jTextField1.getText());
                new AdministratorDao().delete(jTextField1.getText());
                JOptionPane.showMessageDialog(UAFrame,"删除成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UAFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton3.addActionListener(e -> {
            try {
                new UserDao().update(new User(jTextField1.getText(),jTextField2.getText()));
                new AdministratorDao().update(new Administrator(jTextField1.getText(),jTextField2.getText()));
                JOptionPane.showMessageDialog(UAFrame,"修改成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UAFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton4.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(UAFrame,new UserDao().search(jTextField1.getText()).toString(),"提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UAFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton5.addActionListener(e -> UAFrame.setVisible(false));
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        jPanel3.add(jButton4);
        jPanel3.add(jButton5);
        //
        UAFrame.add(jPanel1);
        UAFrame.add(jPanel2);
        UAFrame.add(jPanel3);
        //
        UAFrame.setVisible(true);
    }
}
