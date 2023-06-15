package ui;

import dao.UserDao;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserMassage extends BaseFrameSet{
    public String[][] getUserMassage() throws Exception{
        ArrayList<User> userList= new UserDao().searchAll();
        int count = userList.size();
        String[][] strings = new String[count][2];
        int rows = 0;
        while (rows < count) {
            strings[rows][0] = userList.get(rows).getAccount();
            strings[rows][1] = userList.get(rows).getPassword();
            rows++;
        }
        for (int i = 0;i<3;i++)
            for(int j = 0;j<2;j++)
                System.out.println(strings[i][j]);
        return strings;
    }

    public void open() throws Exception{
        //窗体设置
        JFrame UMassage = new JFrame("用户信息");
        UMassage.setResizable(false);
        UMassage.setLayout(borderLayout);
        UMassage.setSize(600,400);
        UMassage.setLocationRelativeTo(null);
        UMassage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UMassage.setBackground(Color.GRAY);
        //中间面板
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(borderLayoutPanel);
        JLabel jLabel = new JLabel("用户信息");
        String[] TableTitle = {"账号","密码"};
        JTable jTable = new JTable(getUserMassage(),TableTitle);
        jLabel.setFont(Title_font);
        jTable.setVisible(true);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jPanel1.add(jLabel,BorderLayout.NORTH);
        jPanel1.add(jScrollPane,BorderLayout.CENTER);
        //底部
        JPanel jPanel2 = new JPanel();
        JButton jButton = new JButton("返回");
        jButton.setSize(Button_dimension);
        jButton.setFont(Label_font);
        jButton.setBackground(Button_color);
        jButton.addActionListener(e -> UMassage.setVisible(false));
        jPanel2.add(jButton);
        //
        UMassage.add(jPanel1,BorderLayout.CENTER);
        UMassage.add(jPanel2,BorderLayout.SOUTH);
        //
        UMassage.setVisible(true);
    }
}
