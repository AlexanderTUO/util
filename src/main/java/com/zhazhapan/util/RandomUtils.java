/**
 *
 */
package com.zhazhapan.util;

import com.zhazhapan.util.model.SimpleColor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @author pantao
 */
public class RandomUtils {

    private RandomUtils() {}

    /**
     * 获取随机浮点数，保留2位小数，下限为0，上限为{@link Double#MAX_VALUE}
     *
     * @return {@link Double}
     */
    public static double getRandomDouble() {
        return getRandomDouble(0, Double.MAX_VALUE);
    }

    /**
     * 获取随机浮点数，保留2位小数
     *
     * @param floor 下限
     * @param ceil 上限
     *
     * @return {@link Double}
     */
    public static double getRandomDouble(double floor, double ceil) {
        return getRandomDouble(floor, ceil, 2);
    }

    /**
     * 获取随机浮点数
     *
     * @param floor 下限
     * @param ceil 上限
     * @param precision 精度（小数位数）
     *
     * @return {@link Double}
     */
    public static double getRandomDouble(double floor, double ceil, int precision) {
        BigDecimal decimal = new BigDecimal(floor + new Random().nextDouble() * (ceil - floor));
        return decimal.setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 获取随机整数，下限为0，上限为{@link Integer#MAX_VALUE}
     *
     * @return {@link Integer}
     */
    public static int getRandomInteger() {
        return getRandomInteger(0, Integer.MAX_VALUE);
    }

    /**
     * 获取随机整数
     *
     * @param floor 下限
     * @param ceil 上限
     *
     * @return {@link Integer}
     */
    public static int getRandomInteger(int floor, int ceil) {
        return floor + new Random().nextInt(ceil - floor);
    }

    /**
     * 获取随机颜色
     *
     * @param opacity 不透明度
     *
     * @return {@link SimpleColor}
     */
    public static SimpleColor getRandomColor(double opacity) {
        Random ran = new Random();
        int b = ran.nextInt(255);
        int r = 255 - b;
        return new SimpleColor(b + ran.nextInt(r), b + ran.nextInt(r), b + ran.nextInt(r), opacity);

    }

    /**
     * 获取随机颜色，默认不透明
     *
     * @return {@link SimpleColor}
     */
    public static SimpleColor getRandomColor() {
        return getRandomColor(1d);
    }
}