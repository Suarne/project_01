/**
 * @ProjectName: project_01
 * @Package: PACKAGE_NAME
 * @ClassName: Check
 * @Description: 用于检查用户输入数据是否合法
 * @Author: 万世成
 * @CreateDate: 2019/3/8 21:49
 * @UpdateUser: 万世成
 * @UpdateDate: 2019/3/8 21:49
 * @Version: 0.0.1
 * @JDKVesion: 1.8.0
 * @Copyright (c)   2019/3/8 21:49
 */

import java.util.Scanner;

public class Check {
    private int length = 1;
    private int thickness = 1;
    public void check() {
        try {
            System.out.print("请输入等腰三角形的直角边长：");
            Scanner input = new Scanner(System.in);
            this.length = input.nextInt();
            System.out.print("请输入等腰三角形的厚度：");
            this.thickness = input.nextInt();
            //  异常数值判断
            if (length <= 0 || thickness <= 0) {
                System.out.println("输入有误，请输入正整数！！！（例如1、5、12...）");
                System.exit(0);
            } else if (length < thickness) {
                System.out.println("边长必须大于等于厚度！！！");
                System.exit(0);
            }
        } catch (Exception e) {    //   异常数值判断
            System.out.println("输入有误，请输入正整数！！！（例如1、5、12...）");
            e.printStackTrace();
        }
    }

    public int getLength() {
        return this.length;
    }

    public int getThickness() {
        return this.thickness;
    }
}
