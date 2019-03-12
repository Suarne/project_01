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
    private int length    = 0;
    private int width     = 0;
    private int thickness = 0;
    private int height    = 0;
    private int layers    = 0;

    public void check_triangle() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入等腰三角形的直角边长：");
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
        }
    }

    public void check_pyramid() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入金字塔的高度：");
            this.height = input.nextInt();
            System.out.print("请输入金字塔的层数：");
            this.layers = input.nextInt();
            //  异常数值判断
            if (height <= 0 || layers <= 0) {
                System.out.println("输入有误，请输入正整数！！！（例如1、5、12...）");
                System.exit(0);
            }
        } catch (Exception e) {    //   异常数值判断
            System.out.println("输入有误，请输入正整数！！！（例如1、5、12...）");
        }
    }

    public void check_square() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入正方形的边长：");
            this.length = input.nextInt();
            System.out.print("请输入正方形的厚度：");
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
        }
    }

    public void check_rectangle() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入长方形的长：");
            this.length = input.nextInt();
            System.out.print("请输入长方形的宽：");
            this.width = input.nextInt();
            System.out.print("请输入长方形的厚度：");
            this.thickness = input.nextInt();
            //  异常数值判断
            if (length <= 0 || width <= 0 || thickness <= 0) {
                System.out.println("输入有误，请输入正整数！！！（例如1、5、12...）");
                System.exit(0);
            } else if (length < thickness || width < thickness) {
                System.out.println("边长必须大于等于厚度！！！");
                System.exit(0);
            } else if (length < width) {
                System.out.println("长必须大于宽！！！");
                System.exit(0);
            }
        } catch (Exception e) {    //   异常数值判断
            System.out.println("输入有误，请输入正整数！！！（例如1、5、12...）");
        }
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() { return this.width; }

    public int getThickness() {
        return this.thickness;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }
}
