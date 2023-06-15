package ui;

import dao.StudentDao;
import entity.Student;

import javax.swing.*;
import java.awt.*;

public class Set_student extends BaseFrameSet {
    public void open() {
        //窗体设置
        JFrame SFrame = new JFrame("学生信息管理");
        SFrame.setResizable(false);
        SFrame.setLayout(gridLayout2);
        SFrame.setSize(600, 400);
        SFrame.setLocationRelativeTo(null);
        SFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SFrame.setBackground(Color.GRAY);
        //面板一
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel("学号：");
        JTextField jTextField1 = new JTextField();
        jLabel1.setFont(Label_font);
        jTextField1.setPreferredSize(TextField_dimension);
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        //面板二
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel("姓名：");
        JTextField jTextField2 = new JTextField();
        jLabel2.setFont(Label_font);
        jTextField2.setPreferredSize(TextField_dimension);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        //面板三
        JPanel jPanel3 = new JPanel();
        JLabel jLabel3 = new JLabel("性别：");
        JTextField jTextField3 = new JTextField();
        jLabel3.setFont(Label_font);
        jTextField3.setPreferredSize(TextField_dimension);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField3);
        //面板四
        JPanel jPanel4 = new JPanel();
        JLabel jLabel4 = new JLabel("专业：");
        JTextField jTextField4 = new JTextField();
        jLabel4.setFont(Label_font);
        jTextField4.setPreferredSize(TextField_dimension);
        jPanel4.add(jLabel4);
        jPanel4.add(jTextField4);
        //面板五
        JPanel jPanel5 = new JPanel();
        JButton jButton1 = new JButton("添加");
        JButton jButton2 = new JButton("删除");
        jButton1.setFont(Label_font);
        jButton2.setFont(Label_font);
        jButton1.setSize(Button_dimension);
        jButton2.setSize(Button_dimension);
        jButton1.setBackground(Button_color);
        jButton2.setBackground(Button_color);
        JButton jButton3 = new JButton("修改");
        JButton jButton4 = new JButton("查看");
        jButton3.setFont(Label_font);
        jButton4.setFont(Label_font);
        jButton3.setSize(Button_dimension);
        jButton4.setSize(Button_dimension);
        jButton3.setBackground(Button_color);
        jButton4.setBackground(Button_color);
        JButton jButton5 = new JButton("返回");
        jButton5.setFont(Label_font);
        jButton5.setBackground(Button_color);
        jButton5.setSize(Button_dimension);
        jButton1.addActionListener(e -> {
            try {
                new StudentDao().add(new Student(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText()));
                JOptionPane.showMessageDialog(SFrame,"添加成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(SFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton2.addActionListener(e -> {
            try {
                new StudentDao().delete(jTextField1.getText());
                JOptionPane.showMessageDialog(SFrame,"删除成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(SFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton3.addActionListener(e -> {
            try {
                new StudentDao().update(new Student(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText()));
                JOptionPane.showMessageDialog(SFrame,"修改成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(SFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton4.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(SFrame,new StudentDao().search(jTextField1.getText()).toString(),"提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(SFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton5.addActionListener(e -> SFrame.setVisible(false));
        jPanel5.add(jButton1);
        jPanel5.add(jButton2);
        jPanel5.add(jButton3);
        jPanel5.add(jButton4);
        jPanel5.add(jButton5);
        //添加
        SFrame.add(jPanel1);
        SFrame.add(jPanel2);
        SFrame.add(jPanel3);
        SFrame.add(jPanel4);
        SFrame.add(jPanel5);
        //
        SFrame.setVisible(true);
    }
}
