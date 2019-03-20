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

import javax.swing.*;
import java.awt.*;

public class Check {

    public void error_dialog(String string) {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(frame, string, "错误提示！！！", JOptionPane.WARNING_MESSAGE);
    }

    public Check check_triangle(int length, int thickness) {
        //  异常数值判断
        if (length <= 0 || thickness <= 0) {
            error_dialog("输入有误，请输入正整数！！！（例如1、5、12...）");
        } else if (length < thickness) {
            error_dialog("边长必须大于等于厚度！！！");
        }
        return null;
    }

    public Check check_pyramid(int height, int layers) {
        //  异常数值判断
        if (height <= 0 || layers <= 0) {
            error_dialog("输入有误，请输入正整数！！！（例如1、5、12...）");
        }
        return null;
    }

    public Check check_square(int length, int thickness) {
            //  异常数值判断
            if (length <= 0 || thickness <= 0) {
                error_dialog("输入有误，请输入正整数！！！（例如1、5、12...）");
            } else if (length < thickness) {
                error_dialog("边长必须大于等于厚度！！！");
            }
        return null;
    }

    public Check check_rectangle(int length, int width, int thickness) {
            //  异常数值判断
            if (length <= 0 || width <= 0 || thickness <= 0) {
                error_dialog("输入有误，请输入正整数！！！（例如1、5、12...）");
            } else if (length < thickness || width < thickness) {
                error_dialog("边长必须大于等于厚度！！！");
            } else if (length < width) {
                error_dialog("长必须大于宽！！！");
            }
        return null;
    }
}
