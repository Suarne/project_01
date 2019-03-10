import java.util.Collections;

/**
 * @ProjectName: project_01
 * @Package: PACKAGE_NAME
 * @ClassName: Print
 * @Description: 打印出具有厚度且内部镂空的图形
 * @Author: 万世成
 * @CreateDate: 2019/3/9 9:20
 * @Version: 0.2.0
 * @JDKVesion: 1.8.0
 * @Copyright (c)   2019/3/9 9:20
 */
public class Print {
    public Print print_triangle(int length, int thickness) {
        // 打印第一行
        for (int i = 1; i < thickness; i++) {
            System.out.println(String.join("", Collections.nCopies(thickness, "#")));
        }
        // (length > 3*thickness)才会在第(2*thickness+1)行开始产生空格
        int boundary = 3 * thickness;
        if (length <= boundary) {
            for (int i = thickness; i <= length; i++) {
                System.out.println(String.join("", Collections.nCopies(i, "#")));
            }
        } else {
            int i = 0; // 表示第几行
            // 打印首部分
            int head_lines = 2 * thickness;
            for (i = thickness; i <= head_lines; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
            // 打印中间需要镂空部分
            int middle_lines = length - thickness;
            for ( ; i <= middle_lines; i++) {
                System.out.print(String.join("" ,Collections.nCopies(thickness, "#")));
                for (int j = 0; j < i - head_lines; j++) {
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

    public Print print_pyramid(int height, int layers) {
        for(int i = 1; i <= layers; i++) { // 层数
            print_pyramid_single(height, i,layers-i);
            System.out.println();
        }

        return null;
    }

    public Print print_pyramid_single(int height, int layers, int z) {
        String a = "/";
        String b = "\\";
        String c = "--";

        for(int j = height-1; j >= 0; j--) {
            for (int q = 0; q < height * z; q++) {
                System.out.print(" ");
            }

            for (int t = layers; t > 0; t--) {
                for (int k = (2 * height - 1); k >= 0; k--) {
                    if (k == j)
                        System.out.print(b);
                    else if (k == (2 * height - 1 - j))
                        System.out.print(a);
                    else
                        System.out.print(" ");

                }
            }
            System.out.println();
        }

        for(int i = 0; i < height*z; i++) {
            System.out.print(" ");
        }

        for(int i = 0; i < height*layers; i++) {
            System.out.print(c);
        }

        return null;
    }

    public Print print_square(int length, int width, int thickness) {
        // 表示第几行
        int i = 0;
        // 打印首部
        for ( ; i < thickness; i++) {
            System.out.println(String.join("", Collections.nCopies(length, "#")));
        }
        // 打印中间需要镂空部分
        int middle_lines = width - thickness;
        int empty_nums = length - 2 * thickness;
        for ( ; i < middle_lines; i++) {
            System.out.print(String.join("" ,Collections.nCopies(thickness, "#")));
            for (int j = 0; j < empty_nums; j++) {
                System.out.print(" ");
            }
            System.out.println(String.join("", Collections.nCopies(thickness, "#")));
        }
        // 打印尾部
        for ( ; i < width; i++) {
            System.out.println(String.join("", Collections.nCopies(length, "#")));
        }

        return null;
    }
}
