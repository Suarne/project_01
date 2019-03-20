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
    // 将控制台输出打印至Swing面板中，引用对象
    Gui tmp = new Gui();

    public Print print_triangle(int length, int thickness) {
        // 打印第一行
        for (int i = 1; i < thickness; i++) {
            tmp.tx_area.append(String.join("", Collections.nCopies(thickness, "#")) + "\n");
        }
        int boundary = 3 * thickness;
        if (length <= boundary) {
            for (int i = thickness; i <= length; i++) {
                tmp.tx_area.append(String.join("", Collections.nCopies(i, "#")) + "\n");
            }
        } else {
            int i = 0; // 表示第几行
            // 打印首部分
            int head_lines = 2 * thickness;
            for (i = thickness; i <= head_lines; i++) {
                for (int j = 0; j < i; j++) {
                    tmp.tx_area.append("#");
                }
                tmp.tx_area.append("\n");
            }
            // 打印中间需要镂空部分
            int middle_lines = length - thickness;
            for (; i <= middle_lines; i++) {
                tmp.tx_area.append(String.join("", Collections.nCopies(thickness, "#")));
                for (int j = 0; j < i - head_lines; j++) {
                    tmp.tx_area.append(" ");
                }
                tmp.tx_area.append(String.join("", Collections.nCopies(thickness, "#")) + "\n");
            }
            // 打印尾部分
            for (; i <= length; i++) {
                tmp.tx_area.append(String.join("", Collections.nCopies(i, "#")) + "\n");
            }
        }
        return null;
    }

    public Print print_pyramid(int height, int layers) {
        for (int i = 1; i <= layers; i++) { // 层数
            print_pyramid_single(height, i, layers - i);
            tmp.tx_area.append("\n");
        }

        return null;
    }

    private Print print_pyramid_single(int height, int layers, int z) {
        String a = "/";
        String b = "\\";
        String c = "--";

        for (int j = height - 1; j >= 0; j--) {
            for (int q = 0; q < height * z; q++) {
                tmp.tx_area.append(" ");
            }

            for (int t = layers; t > 0; t--) {
                for (int k = (2 * height - 1); k >= 0; k--) {
                    if (k == j)
                        tmp.tx_area.append(b);
                    else if (k == (2 * height - 1 - j))
                        tmp.tx_area.append(a);
                    else
                        tmp.tx_area.append(" ");
                }
            }
            tmp.tx_area.append("\n");
        }

        for (int i = 0; i < height * z; i++) {
            tmp.tx_area.append(" ");
        }

        for (int i = 0; i < height * layers; i++) {
            tmp.tx_area.append(c);
        }

        return null;
    }

    public Print print_square(int length, int width, int thickness) {
        // 表示第几行
        int i = 0;
        // 打印首部
        for (; i < thickness; i++) {
            tmp.tx_area.append(String.join("", Collections.nCopies(length, "#")) + "\n");
        }
        // 打印中间需要镂空部分
        int middle_lines = width - thickness;
        int empty_nums = length - 2 * thickness;
        for (; i < middle_lines; i++) {
            tmp.tx_area.append(String.join("", Collections.nCopies(thickness, "#")));
            for (int j = 0; j < empty_nums; j++) {
                tmp.tx_area.append(" ");
            }
            tmp.tx_area.append(String.join("", Collections.nCopies(thickness, "#")) + "\n");
        }
        // 打印尾部
        for (; i < width; i++) {
            tmp.tx_area.append(String.join("", Collections.nCopies(length, "#")) + "\n");
        }

        return null;
    }
}
