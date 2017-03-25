package com.huajun56.common.util;

/**
 * 生成随机数工具类
 * Created by Bond(China) on 2016/11/24.
 */
public final class RandomUtils {

    private RandomUtils() {
    }

    /**
     * 生成指定长度数字的验证码
     *
     * @param len
     * @return
     */
    public static String randomCode(int len) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append(randomInt());
        }
        return result.toString();
    }

    /**
     * 生成6位默认的数字验证码
     *
     * @return
     */
    public static String randomDefault() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            result.append(randomInt());
        }
        return result.toString();
    }

    /**
     * 生成一位数字随机值
     */
    private static Integer randomInt() {
        return (int) (Math.random() * 10);
    }
}
