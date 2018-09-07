package com.jogeen;

import java.awt.*;

public class Circle {

    //半径
    private int r;

    public int x;//圆心x坐标
    public int y;//圆心y坐标
    public int vx;//x方向速度
    public int vy;//y方向速度
    public boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r < minx) { x = r; vx = -vx; }
        if (x + r >= maxx) { x =maxx- r; vx = -vx; }
        if (y - r < miny) { y = r; vy = -vy; }
        if (y + r >= maxy) { y =maxy- r; vy = -vy; }
    }

    public boolean contain(Point p){
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;
    }
}
