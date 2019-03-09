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
 * @TODO: 需要把加上厚度的三角新镂空
 * @Copyright (c)   2019/3/7 20:33
 */

public class Main {
    public static void main(String[] args) {
        Check ch = new Check();
        ch.check();

//        Print print = new Print().print_triangle(ch.getLength());
//        Print_01 print = new Print_01().print_triangle(ch.getLength(), ch.getThickness());
        Print_02 print = new Print_02().print_triangle(ch.getLength(),ch.getThickness());
    }
}
