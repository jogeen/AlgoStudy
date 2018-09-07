package com.jogeen;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

public class AlgoVisHelper {

    private AlgoVisHelper() {
        throw new RuntimeException("this is util class,can not create object");
    }

    /**
     * 在2d品名绘制一个空心圆
     *
     * @param g 图像上下文
     * @param x 圆心x坐标
     * @param y 圆心y坐标
     * @param r 半径
     */
    public static void strokeCircle(Graphics2D g, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g.draw(circle);
    }

    /**
     * 在2d品名绘制一个实心圆
     *
     * @param g 图像上下文
     * @param x 圆心x坐标
     * @param y 圆心y坐标
     * @param r 半径
     */
    public static void fillCircle(Graphics2D g, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g.fill(circle);
    }

    /**
     * 设置画笔颜色
     *
     * @param g
     * @param color
     */
    public static void setColor(Graphics2D g, Color color) {
        g.setColor(color);
    }

    /**
     * 设置画笔的粗细宽度
     * @param g
     * @param w
     */
    public static void setStrokeWidth(Graphics2D g, int w) {
        int strokeWidth = w;
        g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 线程暂停
     * @param t 毫秒
     */
    public static void pause(int t){
        try {
            TimeUnit.MILLISECONDS.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
