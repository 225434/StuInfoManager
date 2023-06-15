package ui;

import dao.UserDao;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class Set_user extends BaseFrameSet{
    public void open () {
        //界面设置
        JFrame UFrame = new JFrame("用户设置");
        UFrame.setResizable(false);
        UFrame.setLayout(gridLayout4);
        UFrame.setSize(600, 400);
        UFrame.setLocationRelativeTo(null);
        UFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UFrame.setBackground(Color.GRAY);
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
        JButton jButton1= new JButton("修改");
        JButton jButton2 = new JButton("删除");
        jButton1.setFont(Label_font);
        jButton1.setBackground(Button_color);
        jButton1.setSize(Button_dimension);
        jButton2.setFont(Label_font);
        jButton2.setBackground(Button_color);
        jButton2.setSize(Button_dimension);
        JButton jButton3 = new JButton("返回");
        jButton3.setFont(Label_font);
        jButton3.setBackground(Button_color);
        jButton3.setSize(Button_dimension);
        jButton1.addActionListener(e -> {
            try {
                new UserDao().update(new User(jTextField1.getText(),jTextField2.getText()));
                JOptionPane.showMessageDialog(UFrame,"修改成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton2.addActionListener(e -> {
            try {
                new UserDao().delete(jTextField1.getText());
                JOptionPane.showMessageDialog(UFrame,"删除成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton3.addActionListener(e -> UFrame.setVisible(false));
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        //
        UFrame.add(jPanel1);
        UFrame.add(jPanel2);
        UFrame.add(jPanel3);
        //
        UFrame.setVisible(true);
    }
}
