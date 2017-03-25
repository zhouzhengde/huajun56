package com.huajun56.common.util;

/**
 * 字符串操作工具
 * Created by Bond(China) on 2017/2/23.
 */
public final class StringUtils {
    private StringUtils() {
    }

    /**
     * 转换成模糊条件String
     *
     * @param src
     * @param left
     * @param right
     * @return
     */
    public static String toLike(String src, boolean left, boolean right) {
        if ($.isEmpty(src)) {
            return src;
        }
        if (right) {
            src = src + "%";
        }
        if (left) {
            src = "%" + src;
        }
        return src;
    }

    /**
     * 转换成模糊条件String
     *
     * @param src
     * @return "%" + src
     */
    public static String toLeftLike(String src) {
        return toLike(src, true, false);
    }

    /**
     * 转换成模糊条件String
     *
     * @param src
     * @return src + "%"
     */
    public static String toRightLike(String src) {
        return toLike(src, false, true);
    }

    /**
     * 转换成模糊条件String
     *
     * @param src
     * @return "%" + src + "%"
     */
    public static String tBothLike(String src) {
        return toLike(src, true, true);
    }
}
