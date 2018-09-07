import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private MonteCarloSimulation data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        if (sceneHeight!=sceneWidth){
            throw  new IllegalArgumentException("width must equal height");
        }
        // 初始化数据
        // TODO: 初始化数据
        Circle circle=new Circle(sceneWidth/2,sceneWidth/2,sceneWidth/2);
        data=new MonteCarloSimulation(circle,5000);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        while (true){
            frame.render(data);

            AlgoVisHelper.pause(40);
            int x=(int)(Math.random()*frame.getCanvasWidth());
            int y=(int)(Math.random()*frame.getCanvasWidth());
            Point point=new Point(x,y);
            data.add(point);
        }

        // TODO: 编写自己的动画逻辑
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
