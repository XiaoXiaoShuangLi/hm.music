package com.xxscloud.thirdparty.data;

/**
 * @author 李小双 2018.1.29
 */
public class CoordinatesDto {


    /**
     * X轴.
     */
    private double x;

    /**
     * Y轴.
     */
    private double y;

    public CoordinatesDto(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 获取 x .
     *
     * @return x 数据
     */
    public double getX() {
        return x;
    }

    /**
     * 设置 x .
     *
     * @param xValue 设置 x .
     */
    public void setX(final double xValue) {
        x = xValue;
    }

    /**
     * 获取 y .
     *
     * @return y 数据
     */
    public double getY() {
        return y;
    }

    /**
     * 设置 y .
     *
     * @param yValue 设置 y .
     */
    public void setY(final double yValue) {
        y = yValue;
    }
}
