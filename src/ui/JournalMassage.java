package ui;

import dao.JournalDao;
import entity.Journal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JournalMassage extends BaseFrameSet{
    public String[][] getUserMassage() throws Exception{
        ArrayList<Journal> journals = new JournalDao().searchAll();
        int count = journals.size();
        String[][] strings = new String[count][4];
        int rows = 0;
        while (rows < count) {
            strings[rows][0] = journals.get(rows).getData();
            strings[rows][1] = journals.get(rows).getTime();
            strings[rows][2] = journals.get(rows).getOperator();
            strings[rows][3] = journals.get(rows).getAction();
            rows++;
        }
        return strings;
    }

    public void open() throws Exception{
        //窗体设置
        JFrame JournalFrame = new JFrame("日志");
        JournalFrame.setResizable(false);
        JournalFrame.setLayout(borderLayout);
        JournalFrame.setSize(600,400);
        JournalFrame.setLocationRelativeTo(null);
        JournalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JournalFrame.setBackground(Color.GRAY);
        //中间面板
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(borderLayoutPanel);
        JLabel jLabel = new JLabel("日志信息");
        String[] TableTitle = {"日期","时间","操作者","操作"};
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
        jButton.addActionListener(e -> JournalFrame.setVisible(false));
        jPanel2.add(jButton);
        //
        JournalFrame.add(jPanel1,BorderLayout.CENTER);
        JournalFrame.add(jPanel2,BorderLayout.SOUTH);
        //
        JournalFrame.setVisible(true);
    }
}
