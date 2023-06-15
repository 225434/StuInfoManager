package ui;

import dao.JournalDao;
import dao.UserDao;
import entity.Journal;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Login extends BaseFrameSet{
    //界面
    public void open() {
        //窗体设置
        JFrame login = new JFrame("学生信息管理系统登录界面");
        login.setResizable(false);
        login.setLayout(gridLayout2);
        login.setSize(600,400);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setBackground(Color.GRAY);
        //第一层面板
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel("学生信息管理系统");
        jLabel1.setFont(Title_font);
        jPanel1.add(jLabel1);
        //第二层面板
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel("账号：");
        JTextField jTextField1 = new JTextField();
        jLabel2.setFont(Label_font);
        jTextField1.setPreferredSize(TextField_dimension);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField1);
        //第三层面版
        JPanel jPanel3 = new JPanel();
        JLabel jLabel3 = new JLabel("密码：");
        JPasswordField jTextField2 = new JPasswordField();
        jLabel3.setFont(Label_font);
        jTextField2.setPreferredSize(TextField_dimension);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField2);
        //第四层面板
        JPanel jPanel4 = new JPanel();
        JLabel jLabel4 = new JLabel("用户类别：");
        JRadioButton jRadioButton1 = new JRadioButton("管理员");
        JRadioButton jRadioButton2 = new JRadioButton("用户");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jLabel4.setFont(Label_font);
        jRadioButton1.setFont(Label_font);
        jRadioButton2.setFont(Label_font);
        jPanel4.add(jLabel4);
        jPanel4.add(jRadioButton1);
        jPanel4.add(jRadioButton2);
        //第五层面板
        JPanel jPanel5 = new JPanel();
        JButton jButton1 = new JButton("登录");
        JButton jButton2 = new JButton("注册");
        jButton1.setFont(Label_font);
        jButton2.setFont(Label_font);
        jButton1.setBackground(Button_color);
        jButton2.setBackground(Button_color);
        jButton1.setSize(Button_dimension);
        jButton2.setSize(Button_dimension);
        jButton1.addActionListener(e -> {
            try {
                if (new UserDao().search(jTextField1.getText()).getPassword().
                        equals(jTextField2.getText())) {
                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();
                    DateTimeFormatter Date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    DateTimeFormatter Time = DateTimeFormatter.ofPattern("HH:mm:ss");
                    if(jRadioButton1.isSelected()) {
                        new AdministratorFrame().open();
                        new JournalDao().add(new Journal(date.format(Date),
                                time.format(Time),jTextField1.getText(),"登录"));
                    }
                    else {
                        new UserFrame().open();
                        new JournalDao().add(new Journal(date.format(Date),
                                time.format(Time),jTextField1.getText(),"注册"));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(login,"密码错误！",
                            "警告！",JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception sqlException) {
                JOptionPane.showMessageDialog(login,sqlException.getMessage(),
                        "警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jButton2.addActionListener(e -> {
            try {
                if (jRadioButton1.isSelected())
                    JOptionPane.showMessageDialog(login,"无法注册为管理员！","警告！",JOptionPane.WARNING_MESSAGE);
                User user = new User(jTextField1.getText(),jTextField2.getText());
                int flag = new UserDao().add(user);
                if (flag == 1)
                    JOptionPane.showMessageDialog(login,"注册成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(login,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jPanel5.add(jButton1);
        jPanel5.add(jButton2);
        //添加
        login.add(jPanel1);
        login.add(jPanel2);
        login.add(jPanel3);
        login.add(jPanel4);
        login.add(jPanel5);
        //显示界面
        login.setVisible(true);
    }
}
