/**
 * @ProjectName: project_01
 * @Package: none
 * @ClassName: Main
 * @Description: 主方法调用Print类的print_triangle()方法
 * @Author: 万世成
 * @CreateDate: 2019/3/7 20:33
 * @UpdateUser: 万世成
 * @UpdateDate: 2019/3/7 20:40
 * @UpdateRemark: none
 * @Version: 0.0.1
 * @JDKVesion: 1.8.0
 * @TODO: 需要把三角形的厚度加上
 * @Copyright (c)   2019/3/7 20:33
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length = 0;

        System.out.print("请输入等腰三角形的直角边长：");
        try {
            //  获取用户输入的等腰三角形直角边长
            Scanner input = new Scanner(System.in);
            length = input.nextInt();
            //  异常数值判断
            if (length == 0) {
                System.out.println("三角形边长不能为0！！！");
                System.exit(0);
            }
        } catch (Exception e) {    //   异常数值判断
            System.out.println("输入有误，请输入整数！！！（例如1、5、12...）");
            e.printStackTrace();
        }
        //  调用打印方法
        Print print = new Print().print_triangle(length);
    }
}
