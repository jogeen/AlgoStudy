package com.jogeen;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private int canvasWidth;
    private int canvasHight;


    public AlgoFrame(String title, int canvasWidth, int canvasHight) {
        super(title);
        this.canvasHight = canvasHight;
        this.canvasWidth = canvasWidth;
        //设置画布
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();
        //设置宽度和高度
        setSize(canvasWidth, canvasHight);
        //设置默认关闭方式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置用户不能放大或缩小窗口
        setResizable(false);
        //显示窗口
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHight() {
        return canvasHight;
    }


    private Circle[] circles;

    public void render(Circle[] circles) {
        this.circles = circles;
        repaint();
    }


    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            //开启双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //转出2d图像
            Graphics2D g2d = (Graphics2D) g;

            //设置抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            AlgoVisHelper.setStrokeWidth(g2d, 2);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for (Circle circle : circles) {
                if (circle.isFilled) {
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHight);
        }


    }


}
