import java.awt.*;

public class Circle {
    public int x;
    public int y;
    private int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public boolean containt(Point point) {
        return (x-point.x)*(x-point.x)+(y-point.y)*(y-point.y)<=r*r;
    }
}
