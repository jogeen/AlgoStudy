

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // TODO: 设置自己的数据
    private MonteCarloSimulation monteCarloSimulation;
    public void render(MonteCarloSimulation monteCarloSimulation){
        this.monteCarloSimulation = monteCarloSimulation;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            // TODO： 绘制自己的数据data
            Circle circle = monteCarloSimulation.getCircle();
            LinkedList<Point> points = monteCarloSimulation.getPoints();
            AlgoVisHelper.setStrokeWidth(g2d,3);
            AlgoVisHelper.setColor(g2d,AlgoVisHelper.Red);
            AlgoVisHelper.strokeCircle(g2d,circle.x,circle.y,circle.getR());
            for (Point point:points){
                if (circle.containt(point)){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Red);
                }else{
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Blue);
                }
                AlgoVisHelper.fillCircle(g2d,point.x,point.y,2);
            }

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


