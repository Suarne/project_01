import java.util.Collections;

/**
 * @ProjectName: project_01
 * @Package: PACKAGE_NAME
 * @ClassName: Print_02
 * @Description: 打印出具有厚度且内部镂空的等腰直角三角形
 * @Author: 万世成
 * @CreateDate: 2019/3/9 9:20
 * @UpdateUser: 万世成
 * @UpdateDate: 2019/3/9 9:20
 * @UpdateRemark:
 * @Version: 0.2.0
 * @JDKVesion: 1.8.0
 * @Copyright (c)   2019/3/9 9:20
 */
public class Print_02 {
    public Print_02 print_triangle(int length, int thickness) {
        for (int i = 1; i < thickness; i++) {
            System.out.println(String.join("", Collections.nCopies(thickness, "#")));
        }
        // (length > 3*thickness)才会在第(2*thickness+1)行开始产生空格
        if (length <= 3*thickness) {
            for (int i = thickness; i <= length; i++) {
                System.out.println(String.join("", Collections.nCopies(i, "#")));
            }
        } else {
            int i = 0; // 表示第几行
            // 打印首部分
            for (i = thickness; i <= 2 * thickness; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
            // 打印中间需要镂空部分
            for ( ; i <= length - thickness; i++) {
                System.out.print(String.join("" ,Collections.nCopies(thickness, "#")));
                for (int j = 0; j < i - 2 * thickness; j++) {
                    System.out.print(" ");
                }
                System.out.println(String.join("", Collections.nCopies(thickness, "#")));
            }
            // 打印尾部分
            for (; i <= length; i++) {
                System.out.println(String.join("" ,Collections.nCopies(i, "#")));
            }
        }


        return null;
    }
}
