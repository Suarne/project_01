import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ProjectName: SE160705030_job_01
 * @Package: PACKAGE_NAME
 * @ClassName: Gui
 * @Description:
 * @Author: 万世成
 * @CreateDate: 2019/3/14 19:26
 * @Version:
 * @JDKVesion: 1.8.0
 * @TODO: 精简代码
 * @Copyright (c)   2019/3/14 19:26
 */
public class Gui {
    private static JFrame jf;
    protected static JTextArea tx_area;
    public static void main(String[] args) {
        jf = new JFrame("字符绘制");

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 创建中间容器（选项 + 面板）
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel jPanel_btns = new JPanel(gridBagLayout);
        tx_area = new JTextArea(15, 20);
        tx_area.setLineWrap(true);
        // 修正JTextArea控件显示空格宽度太小，导致图形边缘对不上问题
        Font font = new Font(Font.DIALOG_INPUT,Font.PLAIN,13);
        tx_area.setFont(font);

        JScrollPane jScrollPane = new JScrollPane(tx_area);
        // 创建基本组件，并添加到中间容器中
        JButton bt_triangle = new JButton("绘制三角形");
        JButton bt_pyramid = new JButton("绘制金字塔");
        JButton bt_square = new JButton("绘制正方形");
        JButton bt_rectangle = new JButton("绘制长方形");
        JButton bt_exit = new JButton("退出");
        // 各个组件添加事件响应
        Triangle_Btn_Listener triangleBtnListener = new Triangle_Btn_Listener();
        bt_triangle.addActionListener(triangleBtnListener);
        Pyramid_Btn_Listener pyramidBtnListener = new Pyramid_Btn_Listener();
        bt_pyramid.addActionListener(pyramidBtnListener);
        Rectangle_Btn_Listener rectangleBtnListener = new Rectangle_Btn_Listener();
        bt_rectangle.addActionListener(rectangleBtnListener);
        Square_Btn_Listener squareBtnListener = new Square_Btn_Listener();
        bt_square.addActionListener(squareBtnListener);
        bt_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // 添加约束条件，控制布局中各个按钮间距
        constraints.insets = new Insets(10, 10, 10, 10);
        gridBagLayout.addLayoutComponent(bt_triangle, constraints);
        gridBagLayout.addLayoutComponent(bt_pyramid, constraints);
        gridBagLayout.addLayoutComponent(bt_square, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        gridBagLayout.addLayoutComponent(bt_rectangle, constraints);
        constraints.insets = new Insets(0, 10, 20, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.addLayoutComponent(bt_exit, constraints);

        jPanel_btns.add(bt_triangle);
        jPanel_btns.add(bt_pyramid);
        jPanel_btns.add(bt_square);
        jPanel_btns.add(bt_rectangle);
        jPanel_btns.add(bt_exit);
        // 把面板容器作为窗口的内容面板设置到窗口
        jSplitPane.setLeftComponent(jPanel_btns);
        jSplitPane.setRightComponent(jScrollPane);
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setContinuousLayout(true);
        jf.setContentPane(jSplitPane);
        // 窗口大小自适应
        jf.pack();
        // 把窗口位置放置在屏幕中心
        jf.setLocationRelativeTo(null);
        // 显示窗口，前面创建的信息都在内存中
        jf.setVisible(true);
    }

    // 绘图监听类需要使用的对象
    public static JTextField length_textfiled;
    public static JTextField thinkness_textfield;
    public static JTextField width_textfiled;
    public static JTextField height_textfiled;
    public static JTextField layers_textfield;

    public static JButton ok_btn;
    public static JButton back_btn;

    private static class Triangle_Btn_Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("请输入参数");

            length_textfiled = new JTextField(10);
            JPanel panel_01 = new JPanel();
            panel_01.add(new JLabel("请输入三角形的边长："));
            panel_01.add(length_textfiled);

            thinkness_textfield = new JTextField(10);
            JPanel panel_02 = new JPanel();
            panel_02.add(new JLabel("请输入三角形的厚度："));
            panel_02.add(thinkness_textfield);

            ok_btn = new JButton("确认");
            back_btn = new JButton("退出");
            JPanel panel_03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel_03.add(ok_btn);
            panel_03.add(back_btn);

            Box verticalBox = Box.createVerticalBox();
            verticalBox.add(panel_01);
            verticalBox.add(panel_02);
            verticalBox.add(panel_03);

            frame.setContentPane(verticalBox);
            frame.pack();
            frame.setLocation(900, 280);
            frame.setVisible(true);

            Check check = new Check();

            ok_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tx_area.setText("");
                    try {
                        check.check_triangle(Integer.valueOf(length_textfiled.getText()), Integer.valueOf(thinkness_textfield.getText()));
                        Print print = new Print().print_triangle(Integer.valueOf(length_textfiled.getText()), Integer.valueOf(thinkness_textfield.getText()));
                    } catch (Exception e1) {
                        check.error_dialog("输入参数必须为整数！！！");
                    }
                }
            });

            back_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
        }
    }

    private static class Pyramid_Btn_Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("请输入参数");

            height_textfiled = new JTextField(10);
            JPanel panel_01 = new JPanel();
            panel_01.add(new JLabel("请输入金字塔的高度："));
            panel_01.add(height_textfiled);

            layers_textfield = new JTextField(10);
            JPanel panel_02 = new JPanel();
            panel_02.add(new JLabel("请输入金字塔的厚度："));
            panel_02.add(layers_textfield);

            ok_btn = new JButton("确认");
            back_btn = new JButton("退出");
            JPanel panel_03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel_03.add(ok_btn);
            panel_03.add(back_btn);

            Box verticalBox = Box.createVerticalBox();
            verticalBox.add(panel_01);
            verticalBox.add(panel_02);
            verticalBox.add(panel_03);

            frame.setContentPane(verticalBox);
            frame.pack();
            frame.setLocation(900, 280);
            frame.setVisible(true);

            Check check = new Check();

            ok_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tx_area.setText("");
                    try {
                        check.check_pyramid(Integer.valueOf(height_textfiled.getText()), Integer.valueOf(layers_textfield.getText()));
                        Print print = new Print().print_pyramid(Integer.valueOf(height_textfiled.getText()), Integer.valueOf(layers_textfield.getText()));
                    } catch (Exception e1) {
                        check.error_dialog("输入的参数必须为整数！！！");
                    }
                }
            });

            back_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
        }
    }

    private static class Square_Btn_Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("请输入参数");

            length_textfiled = new JTextField(10);
            JPanel panel_01 = new JPanel();
            panel_01.add(new JLabel("请输入正方形的边长："));
            panel_01.add(length_textfiled);

            thinkness_textfield = new JTextField(10);
            JPanel panel_02 = new JPanel();
            panel_02.add(new JLabel("请输入正方形的厚度："));
            panel_02.add(thinkness_textfield);

            ok_btn = new JButton("确认");
            back_btn = new JButton("退出");
            JPanel panel_03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel_03.add(ok_btn);
            panel_03.add(back_btn);

            Box verticalBox = Box.createVerticalBox();
            verticalBox.add(panel_01);
            verticalBox.add(panel_02);
            verticalBox.add(panel_03);

            frame.setContentPane(verticalBox);
            frame.pack();
            frame.setLocation(900, 280);
            frame.setVisible(true);

            Check check = new Check();

            ok_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tx_area.setText("");
                    try {
                        check.check_square(Integer.valueOf(length_textfiled.getText()),
                                Integer.valueOf(thinkness_textfield.getText()));
                        Print print = new Print().print_square(Integer.valueOf(length_textfiled.getText()),
                                Integer.valueOf(length_textfiled.getText()), Integer.valueOf(thinkness_textfield.getText()));
                    } catch (Exception e1) {
                        check.error_dialog("输入的参数必须为整数！！！");
                    }
                }
            });

            back_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
        }
    }

    private static class Rectangle_Btn_Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("请输入参数");

            length_textfiled = new JTextField(10);
            JPanel panel_01 = new JPanel();
            panel_01.add(new JLabel("请输入长方形的长："));
            panel_01.add(length_textfiled);

            width_textfiled = new JTextField(10);
            JPanel panel_02 = new JPanel();
            panel_02.add(new JLabel("请输入长方形的宽："));
            panel_02.add(width_textfiled);

            thinkness_textfield = new JTextField(10);
            JPanel panel_03 = new JPanel();
            panel_03.add(new JLabel("请输入长方形的厚度："));
            panel_03.add(thinkness_textfield);

            ok_btn = new JButton("确认");
            back_btn = new JButton("退出");
            JPanel panel_04 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel_04.add(ok_btn);
            panel_04.add(back_btn);

            Box verticalBox = Box.createVerticalBox();
            verticalBox.add(panel_01);
            verticalBox.add(panel_02);
            verticalBox.add(panel_03);
            verticalBox.add(panel_04);

            frame.setContentPane(verticalBox);
            frame.pack();
            frame.setLocation(900, 280);
            frame.setVisible(true);

            Check check = new Check();

            ok_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tx_area.setText("");
                    try {
                        check.check_rectangle(Integer.valueOf(length_textfiled.getText()),
                                Integer.valueOf(width_textfiled.getText()), Integer.valueOf(thinkness_textfield.getText()));
                        Print print = new Print().print_square(Integer.valueOf(length_textfiled.getText()),
                                Integer.valueOf(width_textfiled.getText()), Integer.valueOf(thinkness_textfield.getText()));
                    } catch (Exception e1) {
                        check.error_dialog("输入的参数必须为整数！！！");
                    }
                }
            });

            back_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
        }
    }
}
