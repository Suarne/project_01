import sun.security.util.SecurityConstants;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * @ProjectName: project_01
 * @Package: none
 * @ClassName: Main
 * @Description: 主方法
 * @Author: 万世成
 * @CreateDate: 2019/3/7 20:33
 * @UpdateUser: 万世成
 * @UpdateDate: 2019/3/8 21:49
 * @UpdateRemark: 加上了三角形的厚度
 * @Version: 0.1.0
 * @JDKVesion: 1.8.0
 * @TODO：实现GUI功能
 * @Copyright (c)   2019/3/7 20:33
 */

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Check ch = new Check();

        System.out.println("************欢迎使用图形绘制程序*************");
        System.out.println("**                                       ");
        System.out.println("**    1.等腰直角三角形        2.金字塔     ");
        System.out.println("**    3.正方形               4.长方形     ");
        System.out.println("**                                       ");
        System.out.println("******************************************");
        System.out.print("请输入你想绘制的图形：");            int fun = 0;
        try {
            Scanner input = new Scanner(System.in);
            fun = input.nextInt();
            if ( fun > 4 || fun <= 0) {
                System.out.println("没有这个功能，请你重新选择");
                Main.remain();
            }
        } catch (Exception e) {
            System.out.println("请输入1~4之间的整数！！！");
            Main.remain();
        }
        // 功能选择
        switch (fun) {
            case 1:
                ch.check_triangle();
                Print print = new Print().print_triangle(ch.getLength(), ch.getThickness());
                Main.remain();
                break;
            case 2:
                ch.check_pyramid();
                Print print1 = new Print().print_pyramid(ch.getHeight(), ch.getLayers());
                Main.remain();
                break;
            case 3:
                ch.check_square();
                Print print2 = new Print().print_square(ch.getLength(), ch.getLength(), ch.getThickness());
                Main.remain();
                break;
            case 4:
                ch.check_rectangle();
                Print print3 = new Print().print_square(ch.getLength(), ch.getWidth(), ch.getThickness());
                Main.remain();
                break;
                default:
                    break;
        }
    }
    // 清屏函数
    public static void clear() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    // 实现重复选择功能（自动的）
    public static void remain() throws AWTException, InterruptedException {
        Thread.currentThread().sleep(3000);
        Main.clear();
        Main.main(null);
    }
}
