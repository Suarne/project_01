/**
 * @ProjectName: project_01
 * @Package: none
 * @ClassName: Print
 * @Description: 提供print_triangle()方法，
 *               变量：i -> 控制三角形打印的边界 | j -> 控制打印三角形的边界符号 | tmp -> 用于判断每行应该打印多少个空格
 *               补充：while()方法用于镂空三角形，每行只需要打印两个边界符号，故叠加j值至i-2
 * @Author: 万世成
 * @CreateDate: 2019/3/7 20:33
 * @UpdateUser: 万世成
 * @UpdateDate: 2019/3/7 20:41
 * @UpdateRemark: 作为镂空三角形参考
 * @Version: 0.0.1
 * @JDKVesion: 1.8.0
 * @Copyright (c)   2019/3/7 20:33
 */

public class Print {
    public Print print_triangle(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");

                int tmp = 0;
                int tmp1 = i - 2;   // 打印每行的空格数
                int tmp2 = i - 1;   // 使j遍历到i-2再打印边界符号
                while (i > 2 && i < length && tmp < tmp1 && j < tmp2) {
                    System.out.print(" ");
                    tmp++;            j++;
                }
            }
            System.out.println();
        }
        return null;
    }
}
