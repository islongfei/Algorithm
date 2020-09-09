package com.longfei.Template;

/**
 * 递归模板
 *
 * @author islongfei
 * @date 2020.09.09
 */
public class Recur {

    private void recur(int level, int param) {

        // 终止条件
        if (level > Integer.MAX_VALUE) {
            return;
        }

        // 处理过程
        process(level, param);

        // 向下递归
        recur(level + 1, param + 1);
    }

    private void process(int level, int param) {
    }
}
