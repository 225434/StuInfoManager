package ui;

import java.awt.*;

public abstract class BaseFrameSet {
    //参数设置
    Dimension TextField_dimension = new Dimension(300, 30);//文本框大小
    Dimension Button_dimension = new Dimension(200, 50);//按钮大小
    Color Button_color = new Color(30,144,255);//按钮背景色
    Font Title_font = new Font("微软雅黑", Font.PLAIN,24);//标题字体
    Font Label_font = new Font("微软雅黑",Font.BOLD,16);//标签字体
    //布局设置
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,100,5);
    BorderLayout borderLayout = new BorderLayout(100,100);
    BorderLayout borderLayoutPanel = new BorderLayout(5,5);
    GridLayout gridLayout2 = new GridLayout(5,1);
    GridLayout gridLayout4 = new GridLayout(3,1);
}
