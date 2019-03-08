/**
 * @ProjectName: project_01
 * @Package: PACKAGE_NAME
 * @ClassName: Print_01
 * @Description: 画出有厚度的等腰直角三角形
 *              注：厚度大于1时，边长必须大于厚度值，否则不成立等腰直角三角形
 * @Author: 万世成
 * @CreateDate: 2019/3/8 20:59
 * @Version: 0.0.1
 * @JDKVesion: 1.8.0
 * @TODO: 需要把加上厚度的三角新镂空
 * @Copyright (c)   2019/3/8 20:59
 */

public class Print_01 {
    public Print_01 print_triangle(int length, int thickness) {
        for (int i = 1; i < thickness; i++) {
            for (int j = 0; j < thickness; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        for (int i = thickness; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        return null;
    }
}
