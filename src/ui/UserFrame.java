package ui;

import dao.StudentDao;
import entity.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserFrame extends BaseFrameSet{
    public void open() throws Exception{
        //窗体设置
        JFrame UserFrame = new JFrame("用户界面");
        UserFrame.setResizable(false);
        UserFrame.setLayout(borderLayout);
        UserFrame.setSize(900,600);
        UserFrame.setLocationRelativeTo(null);
        UserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserFrame.setBackground(Color.GRAY);
        //上边界
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu("管理");
        JMenuItem jMenuItem1 = new JMenuItem("学生管理");
        JMenuItem jMenuItem2 = new JMenuItem("用户管理");
        jMenu1.setFont(Label_font);
        jMenuItem1.setFont(Label_font);
        jMenuItem2.setFont(Label_font);
        jMenuItem1.addActionListener(e -> {
            try {
                new Set_student().open();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UserFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jMenuItem2.addActionListener(e -> {
            try {
                new Set_user().open();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(UserFrame,exception.getMessage(),"警告！",JOptionPane.WARNING_MESSAGE);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenuBar.add(jMenu1);
        //中间
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(borderLayoutPanel);
        JLabel jLabel = new JLabel("学生信息");
        String[] TableTitle = {"学号","姓名","性别","专业"};
        JTable jTable = new JTable(getStudentMassage(),TableTitle);
        jLabel.setFont(Title_font);
        jTable.setVisible(true);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jPanel1.add(jLabel,BorderLayout.NORTH);
        jPanel1.add(jScrollPane,BorderLayout.CENTER);
        //下边界
        JPanel jPanel2 = new JPanel();
        JButton jButton1 = new JButton("重新登录");
        JButton jButton2 = new JButton("退出系统");
        jButton1.setSize(Button_dimension);
        jButton2.setSize(Button_dimension);
        jButton1.setBackground(Button_color);
        jButton2.setBackground(Button_color);
        jButton1.setFont(Label_font);
        jButton2.setFont(Label_font);
        jButton1.addActionListener(e -> {
            UserFrame.setVisible(false);
            new Login().open();
        });
        jButton2.addActionListener(e -> UserFrame.setVisible(false));
        jPanel2.add(jButton1);
        jPanel2.add(jButton2);
        //添加
        UserFrame.setJMenuBar(jMenuBar);
        UserFrame.add(jPanel1,BorderLayout.CENTER);
        UserFrame.add(jPanel2,BorderLayout.SOUTH);
        //
        UserFrame.setVisible(true);
    }

    public String[][] getStudentMassage() throws Exception{
        ArrayList<Student> studentList= new StudentDao().searchAll();
        int count = studentList.size();
        String[][] strings = new String[count][4];
        int rows = 0;
        while (rows < count){
            strings[rows][0] = studentList.get(rows).getId();
            strings[rows][1] = studentList.get(rows).getName();
            strings[rows][2] = studentList.get(rows).getSex();
            strings[rows][3] = studentList.get(rows).getMajor();
            rows++;
        }
        return strings;
    }
}
