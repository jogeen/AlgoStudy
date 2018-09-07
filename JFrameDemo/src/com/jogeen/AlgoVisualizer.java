package com.jogeen;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;
    private  boolean isAnimated=true;

    public AlgoVisualizer(int sceneWidth,int sceneHeight,int N){
        circles =new  Circle[N];
        int R=50;
        for (int i=0;i<N;i++){
            int x=(int) (Math.random()*(sceneWidth-2*R))+R;
            int y=(int) (Math.random()*(sceneHeight-2*R))+R;
            int xv=(int) (Math.random()*11)-5;
            int yv=(int) (Math.random()*11)-5;
            circles[i]=new Circle(x,y,R,xv,yv);
        }
        EventQueue.invokeLater(()->{
            frame=new AlgoFrame("welcome",500,500);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(()->{
                run();
            }).start();
        });
    }
    private void run(){
        while(true){
            frame.render(circles);
            AlgoVisHelper.pause(20);

            if(isAnimated){
                for (Circle circle:circles){
                    circle.move(0,0,frame.getCanvasWidth(),frame.getCanvasHight());
                }
            }
        }
    }
    private class AlgoKeyListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }

    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent evnet){
            evnet.translatePoint(0,-(frame.getBounds().height-frame.getCanvasHight()));
            for (Circle circle:circles){
                if (circle.contain(evnet.getPoint())){
                    circle.isFilled=!circle.isFilled;
                }
            }
        }
    }
    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }

}
